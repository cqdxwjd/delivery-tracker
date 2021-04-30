package com.yunli.web.controller;

import com.yunli.bigdata.dsep.foundation.CustomHttpHeaderNames;
import com.yunli.common.json.JSONArray;
import com.yunli.common.json.JSONObject;
import com.yunli.web.config.*;
import com.yunli.web.doman.OozieCoordJobs;
import com.yunli.web.dto.TableStat;
import com.yunli.web.repositories.DocumentCatalogRepository;
import com.yunli.web.repositories.DocumentResourceRepository;
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

    @Autowired
    public DataResourceController(DataResourceService dataResourceService,
                                  DocumentResourceRepository documentResourceRepository,
                                  RestTemplate restTemplate,
                                  DocumentCatalogRepository documentCatalogRepository,
                                  DataPlatfomrConfiguration dataPlatfomrConfiguration,
                                  HueJdbcTemplateFactory hueJdbcTemplateFactory, OozieJdbcTemplateFactory oozieJdbcTemplateFactory) {
        this.dataResourceService = dataResourceService;
        this.documentResourceRepository = documentResourceRepository;
        this.restTemplate = restTemplate;
        this.documentCatalogRepository = documentCatalogRepository;
        this.dataPlatfomrConfiguration = dataPlatfomrConfiguration;
        this.hueJdbcTemplateFactory = hueJdbcTemplateFactory;
        this.oozieJdbcTemplateFactory = oozieJdbcTemplateFactory;
    }

    @GetMapping("/test")
    @ResponseBody
    public void test() {
        System.out.println(hueJdbcTemplateFactory.getJdbcTemplate());
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
}
