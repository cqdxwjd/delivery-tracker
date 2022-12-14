package com.yunli.web.controller;

import com.yunli.bigdata.dsep.foundation.CustomHttpHeaderNames;
import com.yunli.bigdata.dsep.foundation.WebResult;
import com.yunli.common.json.JSONArray;
import com.yunli.common.json.JSONObject;
import com.yunli.data.sync.config.JobConfig;
import com.yunli.data.sync.config.PluginConfig;
import com.yunli.data.sync.core.HData;
import com.yunli.web.config.*;
import com.yunli.web.domain.OozieCoordJobs;
import com.yunli.web.dto.*;
import com.yunli.web.repositories.*;
import com.yunli.web.service.DataResourceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
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
    private final DataPlatformConfiguration dataPlatformConfiguration;
    private final HueJdbcTemplateFactory hueJdbcTemplateFactory;
    private final OozieJdbcTemplateFactory oozieJdbcTemplateFactory;
    private final TopicRepository topicRepository;
    private final JobInfoRepositoryForResource jobInfoRepositoryForResource;
    private final StubServiceJobRepository stubServiceJobRepository;
    private final HiveCSVConfiguration hiveCSVConfiguration;
    private final ResourceLoader resourceLoader;

    @Autowired
    public DataResourceController(DataResourceService dataResourceService,
                                  DocumentResourceRepository documentResourceRepository,
                                  RestTemplate restTemplate,
                                  DocumentCatalogRepository documentCatalogRepository,
                                  DataPlatformConfiguration dataPlatformConfiguration,
                                  HueJdbcTemplateFactory hueJdbcTemplateFactory,
                                  OozieJdbcTemplateFactory oozieJdbcTemplateFactory,
                                  TopicRepository topicRepository,
                                  JobInfoRepositoryForResource jobInfoRepositoryForResource,
                                  StubServiceJobRepository stubServiceJobRepository,
                                  HiveCSVConfiguration hiveCSVConfiguration,
                                  ResourceLoader resourceLoader) {
        this.dataResourceService = dataResourceService;
        this.documentResourceRepository = documentResourceRepository;
        this.restTemplate = restTemplate;
        this.documentCatalogRepository = documentCatalogRepository;
        this.dataPlatformConfiguration = dataPlatformConfiguration;
        this.hueJdbcTemplateFactory = hueJdbcTemplateFactory;
        this.oozieJdbcTemplateFactory = oozieJdbcTemplateFactory;
        this.topicRepository = topicRepository;
        this.jobInfoRepositoryForResource = jobInfoRepositoryForResource;
        this.stubServiceJobRepository = stubServiceJobRepository;
        this.hiveCSVConfiguration = hiveCSVConfiguration;
        this.resourceLoader = resourceLoader;
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

    // ?????????
    @GetMapping("/")
    public String index() {
        if(dataPlatformConfiguration.getVersion()==2){
            return "index2";
        }
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
                dataPlatformConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatformConfiguration.getUserId(),
                        dataPlatformConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String body;
        int count = 0;
        if (field.equals("status") && nameEn.equals("")) {
            body = restTemplate
                    .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/v1/resources/data-resources?pageNum=" + page + "&pageSize=" + limit,
                            HttpMethod.GET, request, String.class).getBody();
            JSONObject tablesJson = new JSONObject(body);
            count = tablesJson.getInt("totalElementCount");
        } else {
            String tablesBody = restTemplate
                    .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/v1/resources/data-resources",
                            HttpMethod.GET, request, String.class).getBody();
            JSONObject tablesJson = new JSONObject(tablesBody);
            count = tablesJson.getInt("totalElementCount");
            body = restTemplate
                    .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/v1/resources/data-resources?pageNum=1" + "&pageSize=" + count,
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
                    statusString = "?????????";
                    break;
                case 2:
                    statusString = "?????????";
                    break;
                case 1:
                    statusString = "???????????????";
                    break;
                case 3:
                    statusString = "???????????????";
                    break;
                case 4:
                    statusString = "???????????????";
                    break;
                case 5:
                    statusString = "?????????????????????";
                    break;
                case 6:
                    statusString = "?????????????????????";
                    break;
                case 7:
                    statusString = "???????????????";
                    break;
                default:
                    statusString = "????????????";
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
//            if (list.size() < 20) {
//                result = WebResult.success(list);
//                result.setCount(list.size());
//                return ResponseEntity.ok().body(result);
//            }
            int num = list.size() / limit;
            if (page <= num) {
                result = WebResult.success(list.subList((page - 1) * limit, page * limit));
            } else if (page == num + 1) {
                result = WebResult.success(list.subList((page - 1) * limit, list.size() % limit + (page - 1) * limit));
            } else {
                result = WebResult.success(list.subList(0, list.size() % limit));
            }
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
        list.add(dataResourceService.getTableStat("??????"));
        list.add(dataResourceService.getTableStat("??????"));
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
        list.add(dataResourceService.getTableStat("??????"));
        list.add(dataResourceService.getTableStat("??????"));
        log.info("success");
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/table/columns/{id}")
    @ResponseBody
    public ResponseEntity<WebResult<List<ResourceColumnDto>>> getColumns(@PathVariable(name = "id") long id) throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ArrayList<ResourceColumnDto> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                dataPlatformConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatformConfiguration.getUserId(),
                        dataPlatformConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String treeBody = restTemplate
                .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/v1/resources/data-resources/" + id + "?returnColumn=true",
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
    public ResponseEntity<WebResult<List<Object>>> getData(@PathVariable(name = "nameEn") String nameEn) throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        ArrayList<Object> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                dataPlatformConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatformConfiguration.getUserId(),
                        dataPlatformConfiguration.getPrivateKey()
                )
        );
//        Resource conf = resourceLoader.getResource("classpath:data-sync/conf");
        Resource resource = resourceLoader.getResource("classpath:data-sync/job-examples/hive-csv.xml");
//        System.setProperty("hdata.conf.dir", conf.getURI().getPath());
        HData hdata = new HData();
        JobConfig jobConfig = new JobConfig(resource.getInputStream());
        PluginConfig readerConfig = jobConfig.getReaderConfig();
        PluginConfig writerConfig = jobConfig.getWriterConfig();
        readerConfig.setString("table", nameEn);
        readerConfig.setString("metastoreUris", hiveCSVConfiguration.getMetastoreUri());
        readerConfig.setString("database", hiveCSVConfiguration.getDatabase());
        readerConfig.setString("parallelism", hiveCSVConfiguration.getReaderParallelism());
        writerConfig.setString("path", hiveCSVConfiguration.getWriterPath());
        hdata.start(jobConfig);
        return ResponseEntity.ok().body(WebResult.success(null));
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
                dataPlatformConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatformConfiguration.getUserId(),
                        dataPlatformConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/v1/resources/documents",
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
                dataPlatformConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatformConfiguration.getUserId(),
                        dataPlatformConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/v1/resources/documents",
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
        list.add(new DocumentStat("??????", count, nullCount, unMountedCount));
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

        // hue???????????????????????????
        List<Integer> workflows = hueJdbcTemplateFactory.getJdbcTemplate().query("select count(1) from desktop_document2 where type='oozie-workflow2' and is_history=0 and is_trashed=0", new SingleColumnRowMapper<>(Integer.class));
        int oozieJobCount = workflows.get(0);
        // hue????????????????????????
        List<Integer> schedules = hueJdbcTemplateFactory.getJdbcTemplate().query("select count(1) from desktop_document2 where type='oozie-coordinator2' and is_history=0 and is_trashed=0;",
                new SingleColumnRowMapper<>(Integer.class));
        int oozieSchduleCount = schedules.get(0);

        // ????????????????????????????????????
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

        // hue???????????????????????????
        List<Integer> workflows = hueJdbcTemplateFactory.getJdbcTemplate().query("select count(1) from desktop_document2 where type='oozie-workflow2' and is_history=0 and is_trashed=0", new SingleColumnRowMapper<>(Integer.class));
        int oozieJobCount = workflows.get(0);
        // hue????????????????????????
        List<Integer> schedules = hueJdbcTemplateFactory.getJdbcTemplate().query("select count(1) from desktop_document2 where type='oozie-coordinator2' and is_history=0 and is_trashed=0;",
                new SingleColumnRowMapper<>(Integer.class));
        int oozieSchduleCount = schedules.get(0);

        // ????????????????????????????????????
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
        list.add(new ProgramStat("??????", oozieSchduleCount, runningOozieSchduleCount, suspendedOozieSchduleCount, oozieJobCount, hiveScriptCount, shellScriptCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/v2/bus")
    @ResponseBody
    public ResponseEntity<WebResult<List<BusStat>>> busV2() {
        List<BusStat> list = new ArrayList<>();
        long count = topicRepository.count();
        long unMountedCount = topicRepository.countUnmounted();
        list.add(new BusStat("??????", count, unMountedCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/v2/job")
    @ResponseBody
    public ResponseEntity<WebResult<List<JobStat>>> jobV2() {
        List<JobStat> list = new ArrayList<>();
        Long fileImportCount = jobInfoRepositoryForResource.countByType("????????????");
        Long tableImportCount = jobInfoRepositoryForResource.countByType("????????????");
        Long realtimeImportCount = stubServiceJobRepository.countByType("0");
        Long realtimeGovernCount = stubServiceJobRepository.countByType("1");
        Long fileUploadCount = jobInfoRepositoryForResource.countByType("????????????");
        Long tableExportCount = jobInfoRepositoryForResource.countByType("????????????");
        list.add(new JobStat("??????", fileImportCount, tableImportCount, realtimeImportCount, realtimeGovernCount, fileUploadCount, tableExportCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    @GetMapping("/x2/catalog")
    @ResponseBody
    public ResponseEntity<WebResult<List<JobStat>>> catalogX2() {
        List<JobStat> list = new ArrayList<>();
        Long fileImportCount = jobInfoRepositoryForResource.countByType("????????????");
        Long tableImportCount = jobInfoRepositoryForResource.countByType("????????????");
        Long realtimeImportCount = stubServiceJobRepository.countByType("0");
        Long realtimeGovernCount = stubServiceJobRepository.countByType("1");
        Long fileUploadCount = jobInfoRepositoryForResource.countByType("????????????");
        Long tableExportCount = jobInfoRepositoryForResource.countByType("????????????");
        list.add(new JobStat("??????", fileImportCount, tableImportCount, realtimeImportCount, realtimeGovernCount, fileUploadCount, tableExportCount));
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    /**
     * ?????????????????? 1.x ?????????????????????????????????
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
                dataPlatformConfiguration.getAddress(),
                AKSK.getCipherText(
                        dataPlatformConfiguration.getUserId(),
                        dataPlatformConfiguration.getPrivateKey()
                )
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String treeBody = restTemplate
                .exchange(dataPlatformConfiguration.getAddress() + "/x-data-tag-service/v1/resources/datatag-trees",
                        HttpMethod.GET, request, String.class).getBody();
        assert treeBody != null;
        JSONObject treeJson = new JSONObject(treeBody);
        JSONArray treeData = ((JSONObject) treeJson.get("data")).getJSONArray("data");
        HashMap<Long, TreeObject> longTreeObjectHashMap = new HashMap<>();
        for (Object tree : treeData) {
            JSONObject jsonObject = (JSONObject) tree;
            Integer treeId = jsonObject.getInt("id");
            String treeName = jsonObject.getString("name");
            longTreeObjectHashMap.put(jsonObject.getLong("id"), new TreeObject(treeName, treeId, null, new ArrayList<>(), null, false, false, false));

            String tagBody = restTemplate
                    .exchange(dataPlatformConfiguration.getAddress() + "/x-data-tag-service/v1/resources/datatag-tags/names?treeId=" + jsonObject.getLong("id") + "&hasAllNodes=true",
                            HttpMethod.GET, request, String.class).getBody();
            assert tagBody != null;
            JSONObject tagJson = new JSONObject(tagBody);
            JSONArray tagData = tagJson.getJSONArray("data");
            ArrayList<TreeObject> topList = new ArrayList<>();
            for (Object tagObject : tagData) {
                JSONObject tag = (JSONObject) tagObject;
                if (tag.get("parentId").toString().equals("null")) {
                    TreeObject t = new TreeObject(tag.getString("name"), tag.getInt("id"), null, null, null, false, false, false);
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

    private List<TreeObject> getSubList(Integer id, JSONArray tagData) {
        ArrayList<TreeObject> childList = new ArrayList<>();
        String pid;

        for (Object tagObject : tagData) {
            JSONObject tag = (JSONObject) tagObject;
            pid = tag.get("parentId").toString();
            if (Long.toString(id).equals(pid)) {
                childList.add(new TreeObject(tag.getString("name"), tag.getInt("id"), null, null, null, false, false, false));
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
