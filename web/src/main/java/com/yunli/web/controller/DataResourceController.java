package com.yunli.web.controller;

import com.yunli.bigdata.dsep.foundation.CustomHttpHeaderNames;
import com.yunli.bigdata.dsep.foundation.WebResult;
import com.yunli.common.json.JSONArray;
import com.yunli.common.json.JSONObject;
import com.yunli.web.config.*;
import com.yunli.web.doman.OozieCoordJobs;
import com.yunli.web.dto.*;
import com.yunli.web.repositories.*;
import com.yunli.web.service.DataResourceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Slf4j
@Controller
public class DataResourceController {

    private final DataResourceService dataResourceService;
    private final DocumentResourceRepository documentResourceRepository;
    private final RestTemplate restTemplate;
    private final DocumentCatalogRepository documentCatalogRepository;
    private final DataPlatfomrConfiguration dataPlatfomrConfiguration;
    private final HueJdbcTemplateFactory hueJdbcTemplateFactory;
    private final OozieJdbcTemplateFactory oozieJdbcTemplateFactory;
    private final TopicRepository topicRepository;
    private final JobInfoRepositoryForResource jobInfoRepositoryForResource;
    private final StubServiceJobRepository stubServiceJobRepository;

    @Autowired
    public DataResourceController(DataResourceService dataResourceService,
                                  DocumentResourceRepository documentResourceRepository,
                                  RestTemplate restTemplate,
                                  DocumentCatalogRepository documentCatalogRepository,
                                  DataPlatfomrConfiguration dataPlatfomrConfiguration,
                                  HueJdbcTemplateFactory hueJdbcTemplateFactory,
                                  OozieJdbcTemplateFactory oozieJdbcTemplateFactory,
                                  TopicRepository topicRepository,
                                  JobInfoRepositoryForResource jobInfoRepositoryForResource,
                                  StubServiceJobRepository stubServiceJobRepository) {
        this.dataResourceService = dataResourceService;
        this.documentResourceRepository = documentResourceRepository;
        this.restTemplate = restTemplate;
        this.documentCatalogRepository = documentCatalogRepository;
        this.dataPlatfomrConfiguration = dataPlatfomrConfiguration;
        this.hueJdbcTemplateFactory = hueJdbcTemplateFactory;
        this.oozieJdbcTemplateFactory = oozieJdbcTemplateFactory;
        this.topicRepository = topicRepository;
        this.jobInfoRepositoryForResource = jobInfoRepositoryForResource;
        this.stubServiceJobRepository = stubServiceJobRepository;
    }

    @GetMapping("/one")
    public String one() {
        return "statistic";
    }

    @GetMapping("/two")
    public String two() {
        return "catalog";
    }

    @GetMapping("/three")
    public String three() {
        return "model";
    }

    @GetMapping("/createTableControl")
    public String createTableControl() {
        return "createTable";
    }

    // 合体页
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/table/all")
    public ResponseEntity<WebResult<List<DataResourceDto>>> getAllTables(@RequestParam(name = "page") int page,
                                                                         @RequestParam(name = "limit") int limit,
                                                                         @RequestParam(name = "nameEn", defaultValue = "") String nameEn,
                                                                         @RequestParam(name = "field", defaultValue = "status") String field,
                                                                         @RequestParam(name = "order", defaultValue = "asc") String order) throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ArrayList<DataResourceDto> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                dataPlatfomrConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatfomrConfiguration.getUserId(),
                        dataPlatfomrConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String body;
        int count = 0;
        if (field.equals("status") && nameEn.equals("")) {
            body = restTemplate
                    .exchange(dataPlatfomrConfiguration.getAddress() + "/x-data-resource-service/v1/resources/data-resources?pageNum=" + page + "&pageSize=" + limit,
                            HttpMethod.GET, request, String.class).getBody();
            JSONObject tablesJson = new JSONObject(body);
            count = tablesJson.getInt("totalElementCount");
        } else {
            String tablesBody = restTemplate
                    .exchange(dataPlatfomrConfiguration.getAddress() + "/x-data-resource-service/v1/resources/data-resources",
                            HttpMethod.GET, request, String.class).getBody();
            JSONObject tablesJson = new JSONObject(tablesBody);
            count = tablesJson.getInt("totalElementCount");
            body = restTemplate
                    .exchange(dataPlatfomrConfiguration.getAddress() + "/x-data-resource-service/v1/resources/data-resources?pageNum=1" + "&pageSize=" + count,
                            HttpMethod.GET, request, String.class).getBody();
        }

        JSONObject tablesJson = new JSONObject(body);
        JSONArray tablesJsonArray = tablesJson.getJSONArray("data");
        for (Object o : tablesJsonArray) {
            JSONObject o1 = (JSONObject) o;
            int status = o1.getInt("status");
            String statusString;
            switch (status) {
                case 0:
                    statusString = "未发布";
                    break;
                case 2:
                    statusString = "已发布";
                    break;
                case 1:
                    statusString = "发布审核中";
                    break;
                case 3:
                    statusString = "变更审核中";
                    break;
                case 4:
                    statusString = "下架审核中";
                    break;
                case 5:
                    statusString = "关联目录审核中";
                    break;
                case 6:
                    statusString = "加载数据审核中";
                    break;
                case 7:
                    statusString = "数据加载中";
                    break;
                default:
                    statusString = "未知状态";
            }
            String nameEn1 = o1.getString("nameEn");
            if (nameEn.equals("") || nameEn1.contains(nameEn)) {
                list.add(new DataResourceDto(o1.getString("nameCn"), nameEn1, statusString, o1.getInt("count"), o1.getInt("id"), o1.getString("createTime")));
            }
        }
        if (!field.equals("status")) {
            list.sort(new Comparator<DataResourceDto>() {
                @SneakyThrows
                @Override
                public int compare(DataResourceDto o1, DataResourceDto o2) {
                    if (order.equals("asc")) {
                        switch (field) {
                            case "nameCn":
                                return o1.getNameCn().compareTo(o2.getNameCn());
                            case "nameEn":
                                return o1.getNameEn().compareTo(o2.getNameEn());
                            case "count":
                                return o1.getCount() - o2.getCount();
                            case "createTime":
                                return o1.getCreateTime().compareTo(o2.getCreateTime());
                            default:
                                throw new Exception();
                        }
                    } else if (order.equals("desc")) {
                        switch (field) {
                            case "nameCn":
                                return o2.getNameCn().compareTo(o1.getNameCn());
                            case "nameEn":
                                return o2.getNameEn().compareTo(o1.getNameEn());
                            case "count":
                                return o2.getCount() - o1.getCount();
                            case "createTime":
                                return o2.getCreateTime().compareTo(o1.getCreateTime());
                            default:
                                throw new Exception();
                        }
                    } else {
                        throw new Exception();
                    }

                }
            });
        }
        WebResult<List<DataResourceDto>> result = null;
        if (field.equals("status") && nameEn.equals("")) {
            result = WebResult.success(list);
            result.setCount(count);
        } else {
            result = WebResult.success(list.subList((page - 1) * limit, page * limit));
            result.setCount(list.size());
        }
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping("/table")
    public String table(Model model) {
        ArrayList<TableStat> list = new ArrayList<>();
        list.add(dataResourceService.getTableStat("stg"));
        list.add(dataResourceService.getTableStat("ods"));
        list.add(dataResourceService.getTableStat("dwd"));
        list.add(dataResourceService.getTableStat("dws"));
        list.add(dataResourceService.getTableStat("adm"));
        list.add(dataResourceService.getTableStat("dim"));
        list.add(dataResourceService.getTableStat("其他"));
        list.add(dataResourceService.getTableStat("总共"));
        model.addAttribute("list", list);
        log.info("success");
        return "table";
    }

    @GetMapping("/v2/table")
    @ResponseBody
    public ResponseEntity<WebResult<ArrayList<TableStat>>> tableV2() {
        ArrayList<TableStat> list = new ArrayList<>();
        list.add(dataResourceService.getTableStat("stg"));
        list.add(dataResourceService.getTableStat("ods"));
        list.add(dataResourceService.getTableStat("dwd"));
        list.add(dataResourceService.getTableStat("dws"));
        list.add(dataResourceService.getTableStat("adm"));
        list.add(dataResourceService.getTableStat("dim"));
        list.add(dataResourceService.getTableStat("其他"));
        list.add(dataResourceService.getTableStat("总共"));
        log.info("success");
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/table/columns/{id}")
    @ResponseBody
    public ResponseEntity<WebResult<List<ResourceColumnDto>>> getColumns(@PathVariable(name = "id") long id) throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ArrayList<ResourceColumnDto> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                dataPlatfomrConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatfomrConfiguration.getUserId(),
                        dataPlatfomrConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String treeBody = restTemplate
                .exchange(dataPlatfomrConfiguration.getAddress() + "/x-data-resource-service/v1/resources/data-resources/" + id + "?returnColumn=true",
                        HttpMethod.GET, request, String.class).getBody();
        JSONObject jsonObject = new JSONObject(treeBody);
        JSONObject data = jsonObject.getJSONObject("data");
        String nameEn = data.getString("nameEn");
        String nameCn = data.getString("nameCn");
        int order = 1;
        JSONArray resourceColumns = data.getJSONArray("resourceColumns");
        for (Object resourceColumn : resourceColumns) {
            JSONObject resourceColumn1 = (JSONObject) resourceColumn;
            list.add(new ResourceColumnDto(
                    nameEn,
                    nameCn,
                    order++,
                    resourceColumn1.getString("columnName"),
                    resourceColumn1.getString("columnDescription"),
                    resourceColumn1.getString("columnType"),
                    resourceColumn1.getString("columnDescription"),
                    resourceColumn1.getBoolean("partitionColumn")
            ));
        }
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/table/{nameEn}")
    @ResponseBody
    public ResponseEntity<WebResult<List<Object>>> getData(@PathVariable(name = "nameEn") String nameEn) throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ArrayList<Object> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                dataPlatfomrConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatfomrConfiguration.getUserId(),
                        dataPlatfomrConfiguration.getPrivateKey()
                )
        );
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @RequestMapping("/document")
    public String document(Model model) throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException,
            InvalidKeySpecException {
        long count = documentResourceRepository.count();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                dataPlatfomrConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatfomrConfiguration.getUserId(),
                        dataPlatfomrConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(dataPlatfomrConfiguration.getAddress() + "/x-data-resource-service/v1/resources/documents",
                        HttpMethod.GET, request, String.class);
        String body = responseEntity.getBody();
        JSONObject jsonObject = new JSONObject(body);
        JSONArray data = jsonObject.getJSONArray("data");
        int nullCount = 0;
        int unMountedCount = 0;
        for (Object doc : data) {
            JSONObject json = (JSONObject) doc;
            if (json.getInt("count") == 0) {
                nullCount++;
            }
            if (null == documentCatalogRepository.findByDocumentId(json.getLong("id")).orElse(null)) {
                unMountedCount++;
            }
        }
        model.addAttribute("count", count);
        model.addAttribute("nullCount", nullCount);
        model.addAttribute("unMountedCount", unMountedCount);
        return "document";
    }

    @GetMapping("/v2/document")
    @ResponseBody
    public ResponseEntity<WebResult<List<DocumentStat>>> documentV2() throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException,
            InvalidKeySpecException {
        List<DocumentStat> list = new ArrayList<>();
        long count = documentResourceRepository.count();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                dataPlatfomrConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatfomrConfiguration.getUserId(),
                        dataPlatfomrConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(dataPlatfomrConfiguration.getAddress() + "/x-data-resource-service/v1/resources/documents",
                        HttpMethod.GET, request, String.class);
        String body = responseEntity.getBody();
        JSONObject jsonObject = new JSONObject(body);
        JSONArray data = jsonObject.getJSONArray("data");
        int nullCount = 0;
        int unMountedCount = 0;
        for (Object doc : data) {
            JSONObject json = (JSONObject) doc;
            if (json.getInt("count") == 0) {
                nullCount++;
            }
            if (null == documentCatalogRepository.findByDocumentId(json.getLong("id")).orElse(null)) {
                unMountedCount++;
            }
        }
        list.add(new DocumentStat("总计", count, nullCount, unMountedCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/program")
    public String program(Model model) throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException,
            InvalidKeySpecException {
        int runningOozieSchduleCount = 0;
        int suspendedOozieSchduleCount = 0;
        HttpEntity<Object> request = new HttpEntity<>(null, new HttpHeaders());

        JdbcTemplate oozieJdbcTemplate = oozieJdbcTemplateFactory.getJdbcTemplate();
        List<OozieCoordJobs> jobs = oozieJdbcTemplate.query("select app_name,status from coord_jobs", new RowMapper<OozieCoordJobs>() {
            @Override
            public OozieCoordJobs mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new OozieCoordJobs(rs.getString(1),
                        rs.getString(2));
            }
        });
        for (OozieCoordJobs job : jobs) {
            if (job.getStatus().equals("RUNNING")) {
                runningOozieSchduleCount++;
            }
            if (job.getStatus().equals("SUSPENDED")) {
                suspendedOozieSchduleCount++;
            }
        }

        // hue中工作流配置的数量
        List<Integer> workflows = hueJdbcTemplateFactory.getJdbcTemplate().query("select count(1) from desktop_document2 where type='oozie-workflow2' and is_history=0 and is_trashed=0", new SingleColumnRowMapper<>(Integer.class));
        int oozieJobCount = workflows.get(0);
        // hue中调度配置的数量
        List<Integer> schedules = hueJdbcTemplateFactory.getJdbcTemplate().query("select count(1) from desktop_document2 where type='oozie-coordinator2' and is_history=0 and is_trashed=0;",
                new SingleColumnRowMapper<>(Integer.class));
        int oozieSchduleCount = schedules.get(0);

        // 解析工作流中包含的脚本数
        int hiveScriptCount = 0;
        int shellScriptCount = 0;
        List<WorkflowScriptsData> workflowScriptsDataList = hueJdbcTemplateFactory.getJdbcTemplate().query("select name,data from desktop_document2 where type='oozie-workflow2' and is_history=0 and is_trashed=0",
                new BeanPropertyRowMapper<>(WorkflowScriptsData.class));
        for (WorkflowScriptsData workflowScriptsData : workflowScriptsDataList) {
            JSONObject jsonObject = new JSONObject(workflowScriptsData.getData());
            JSONObject scripts = (JSONObject) (jsonObject.get("workflow"));
            JSONArray nodes = scripts.getJSONArray("nodes");
            for (Object node : nodes) {
                JSONObject nodeJson = (JSONObject) node;
                String type = nodeJson.getString("type");
                if (type.contains("hive")) {
                    hiveScriptCount++;
                } else if (type.contains("shell")) {
                    shellScriptCount++;
                }
            }
        }
        model.addAttribute("oozieSchduleCount", oozieSchduleCount);
        model.addAttribute("runningOozieSchduleCount", runningOozieSchduleCount);
        model.addAttribute("suspendedOozieSchduleCount", suspendedOozieSchduleCount);
        model.addAttribute("oozieJobCount", oozieJobCount);
        model.addAttribute("hiveScriptCount", hiveScriptCount);
        model.addAttribute("shellScriptCount", shellScriptCount);
        return "program";
    }

    @GetMapping("/v2/program")
    @ResponseBody
    public ResponseEntity<WebResult<List<ProgramStat>>> programV2() throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException,
            InvalidKeySpecException {
        List<ProgramStat> list = new ArrayList<>();
        int runningOozieSchduleCount = 0;
        int suspendedOozieSchduleCount = 0;
        HttpEntity<Object> request = new HttpEntity<>(null, new HttpHeaders());

        JdbcTemplate oozieJdbcTemplate = oozieJdbcTemplateFactory.getJdbcTemplate();
        List<OozieCoordJobs> jobs = oozieJdbcTemplate.query("select app_name,status from coord_jobs", new RowMapper<OozieCoordJobs>() {
            @Override
            public OozieCoordJobs mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new OozieCoordJobs(rs.getString(1),
                        rs.getString(2));
            }
        });
        for (OozieCoordJobs job : jobs) {
            if (job.getStatus().equals("RUNNING")) {
                runningOozieSchduleCount++;
            }
            if (job.getStatus().equals("SUSPENDED")) {
                suspendedOozieSchduleCount++;
            }
        }

        // hue中工作流配置的数量
        List<Integer> workflows = hueJdbcTemplateFactory.getJdbcTemplate().query("select count(1) from desktop_document2 where type='oozie-workflow2' and is_history=0 and is_trashed=0", new SingleColumnRowMapper<>(Integer.class));
        int oozieJobCount = workflows.get(0);
        // hue中调度配置的数量
        List<Integer> schedules = hueJdbcTemplateFactory.getJdbcTemplate().query("select count(1) from desktop_document2 where type='oozie-coordinator2' and is_history=0 and is_trashed=0;",
                new SingleColumnRowMapper<>(Integer.class));
        int oozieSchduleCount = schedules.get(0);

        // 解析工作流中包含的脚本数
        int hiveScriptCount = 0;
        int shellScriptCount = 0;
        List<WorkflowScriptsData> workflowScriptsDataList = hueJdbcTemplateFactory.getJdbcTemplate().query("select name,data from desktop_document2 where type='oozie-workflow2' and is_history=0 and is_trashed=0",
                new BeanPropertyRowMapper<>(WorkflowScriptsData.class));
        for (WorkflowScriptsData workflowScriptsData : workflowScriptsDataList) {
            JSONObject jsonObject = new JSONObject(workflowScriptsData.getData());
            JSONObject scripts = (JSONObject) (jsonObject.get("workflow"));
            JSONArray nodes = scripts.getJSONArray("nodes");
            for (Object node : nodes) {
                JSONObject nodeJson = (JSONObject) node;
                String type = nodeJson.getString("type");
                if (type.contains("hive")) {
                    hiveScriptCount++;
                } else if (type.contains("shell")) {
                    shellScriptCount++;
                }
            }
        }
        list.add(new ProgramStat("汇总", oozieSchduleCount, runningOozieSchduleCount, suspendedOozieSchduleCount, oozieJobCount, hiveScriptCount, shellScriptCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/v2/bus")
    @ResponseBody
    public ResponseEntity<WebResult<List<BusStat>>> busV2() {
        List<BusStat> list = new ArrayList<>();
        long count = topicRepository.count();
        long unMountedCount = topicRepository.countUnmounted();
        list.add(new BusStat("汇总", count, unMountedCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/v2/job")
    @ResponseBody
    public ResponseEntity<WebResult<List<JobStat>>> jobV2() {
        List<JobStat> list = new ArrayList<>();
        Long fileImportCount = jobInfoRepositoryForResource.countByType("文件导入");
        Long tableImportCount = jobInfoRepositoryForResource.countByType("库表导入");
        Long realtimeImportCount = stubServiceJobRepository.countByType("0");
        Long realtimeGovernCount = stubServiceJobRepository.countByType("1");
        Long fileUploadCount = jobInfoRepositoryForResource.countByType("文件上传");
        Long tableExportCount = jobInfoRepositoryForResource.countByType("库表导出");
        list.add(new JobStat("汇总", fileImportCount, tableImportCount, realtimeImportCount, realtimeGovernCount, fileUploadCount, tableExportCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/x2/catalog")
    @ResponseBody
    public ResponseEntity<WebResult<List<JobStat>>> catalogX2() {
        List<JobStat> list = new ArrayList<>();
        Long fileImportCount = jobInfoRepositoryForResource.countByType("文件导入");
        Long tableImportCount = jobInfoRepositoryForResource.countByType("库表导入");
        Long realtimeImportCount = stubServiceJobRepository.countByType("0");
        Long realtimeGovernCount = stubServiceJobRepository.countByType("1");
        Long fileUploadCount = jobInfoRepositoryForResource.countByType("文件上传");
        Long tableExportCount = jobInfoRepositoryForResource.countByType("库表导出");
        list.add(new JobStat("汇总", fileImportCount, tableImportCount, realtimeImportCount, realtimeGovernCount, fileUploadCount, tableExportCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    /**
     * 对接数据中台 1.x 版本的资源目录展示方法
     *
     * @author wangjingdong
     * @date 2021/5/28 10:12
     */
    @GetMapping("/catalog")
    @ResponseBody
    public ResponseEntity<ArrayList<TreeObject>> catalog() throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ArrayList<TreeObject> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                dataPlatfomrConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatfomrConfiguration.getUserId(),
                        dataPlatfomrConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String treeBody = restTemplate
                .exchange(dataPlatfomrConfiguration.getAddress() + "/x-data-tag-service/v1/resources/datatag-trees",
                        HttpMethod.GET, request, String.class).getBody();
        assert treeBody != null;
        JSONObject treeJson = new JSONObject(treeBody);
        JSONArray treeData = ((JSONObject) treeJson.get("data")).getJSONArray("data");
        HashMap<Long, TreeObject> longTreeObjectHashMap = new HashMap<>();
        for (Object tree : treeData) {
            JSONObject jsonObject = (JSONObject) tree;
            long treeId = jsonObject.getLong("id");
            String treeName = jsonObject.getString("name");
            longTreeObjectHashMap.put(jsonObject.getLong("id"), new TreeObject(treeName, treeId, null, new ArrayList<>(), null, false, false, false));

            String tagBody = restTemplate
                    .exchange(dataPlatfomrConfiguration.getAddress() + "/x-data-tag-service/v1/resources/datatag-tags/names?treeId=" + jsonObject.getLong("id") + "&hasAllNodes=true",
                            HttpMethod.GET, request, String.class).getBody();
            assert tagBody != null;
            JSONObject tagJson = new JSONObject(tagBody);
            JSONArray tagData = tagJson.getJSONArray("data");
            ArrayList<TreeObject> topList = new ArrayList<>();
            for (Object tagObject : tagData) {
                JSONObject tag = (JSONObject) tagObject;
                if (tag.get("parentId").toString().equals("null")) {
                    TreeObject t = new TreeObject(tag.getString("name"), tag.getLong("id"), null, null, null, false, false, false);
                    topList.add(t);
                    longTreeObjectHashMap.get(treeId).addChild(t);
                }
            }
            for (TreeObject treeObject : topList) {
                treeObject.setChildren(getSubList(treeObject.getId(), tagData));
            }
        }
        for (Map.Entry<Long, TreeObject> longTreeObjectEntry : longTreeObjectHashMap.entrySet()) {
            list.add(longTreeObjectEntry.getValue());
        }
        return ResponseEntity.ok().body(list);
    }

    private List<TreeObject> getSubList(Long id, JSONArray tagData) {
        ArrayList<TreeObject> childList = new ArrayList<>();
        String pid;

        for (Object tagObject : tagData) {
            JSONObject tag = (JSONObject) tagObject;
            pid = tag.get("parentId").toString();
            if (Long.toString(id).equals(pid)) {
                childList.add(new TreeObject(tag.getString("name"), tag.getLong("id"), null, null, null, false, false, false));
            }
        }

        for (TreeObject treeObject : childList) {
            treeObject.setChildren(getSubList(treeObject.getId(), tagData));
        }

        if (childList.size() == 0) {
            return null;
        }

        return childList;
    }
}
