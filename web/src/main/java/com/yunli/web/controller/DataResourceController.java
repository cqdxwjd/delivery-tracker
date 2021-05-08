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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        String str = "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":[{\"id\":10000,\"username\":\"user-0\",\"sex\":\"女\",\"city\":\"城市-0\",\"sign\":\"签名-0\",\"experience\":255,\"logins\":24,\"wealth\":82830700,\"classify\":\"作家\",\"score\":57},{\"id\":10001,\"username\":\"user-1\",\"sex\":\"男\",\"city\":\"城市-1\",\"sign\":\"签名-1\",\"experience\":884,\"logins\":58,\"wealth\":64928690,\"classify\":\"词人\",\"score\":27},{\"id\":10002,\"username\":\"user-2\",\"sex\":\"女\",\"city\":\"城市-2\",\"sign\":\"签名-2\",\"experience\":650,\"logins\":77,\"wealth\":6298078,\"classify\":\"酱油\",\"score\":31},{\"id\":10003,\"username\":\"user-3\",\"sex\":\"女\",\"city\":\"城市-3\",\"sign\":\"签名-3\",\"experience\":362,\"logins\":157,\"wealth\":37117017,\"classify\":\"诗人\",\"score\":68},{\"id\":10004,\"username\":\"user-4\",\"sex\":\"男\",\"city\":\"城市-4\",\"sign\":\"签名-4\",\"experience\":807,\"logins\":51,\"wealth\":76263262,\"classify\":\"作家\",\"score\":6},{\"id\":10005,\"username\":\"user-5\",\"sex\":\"女\",\"city\":\"城市-5\",\"sign\":\"签名-5\",\"experience\":173,\"logins\":68,\"wealth\":60344147,\"classify\":\"作家\",\"score\":87},{\"id\":10006,\"username\":\"user-6\",\"sex\":\"女\",\"city\":\"城市-6\",\"sign\":\"签名-6\",\"experience\":982,\"logins\":37,\"wealth\":57768166,\"classify\":\"作家\",\"score\":34},{\"id\":10007,\"username\":\"user-7\",\"sex\":\"男\",\"city\":\"城市-7\",\"sign\":\"签名-7\",\"experience\":727,\"logins\":150,\"wealth\":82030578,\"classify\":\"作家\",\"score\":28},{\"id\":10008,\"username\":\"user-8\",\"sex\":\"男\",\"city\":\"城市-8\",\"sign\":\"签名-8\",\"experience\":951,\"logins\":133,\"wealth\":16503371,\"classify\":\"词人\",\"score\":14},{\"id\":10009,\"username\":\"user-9\",\"sex\":\"女\",\"city\":\"城市-9\",\"sign\":\"签名-9\",\"experience\":484,\"logins\":25,\"wealth\":86801934,\"classify\":\"词人\",\"score\":75}]}";
        return str;
    }

    // 合体页
    @GetMapping("/")
    public String one() {
        return "one";
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
}
