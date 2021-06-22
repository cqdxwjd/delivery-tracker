package com.yunli.web.controller;

import com.yunli.bigdata.dsep.foundation.CustomHttpHeaderNames;
import com.yunli.bigdata.dsep.foundation.WebResult;
import com.yunli.common.json.JSONArray;
import com.yunli.common.json.JSONObject;
import com.yunli.web.config.*;
import com.yunli.web.doman.TableDomain2x;
import com.yunli.web.dto.*;
import com.yunli.web.repositories.*;
import com.yunli.web.service.DataResourceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

@Slf4j
@Controller
public class DataResource2XController {

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
    public DataResource2XController(DataResourceService dataResourceService,
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

    @GetMapping("/one/2x")
    public String one() {
        return "statistic2";
    }

    @GetMapping("/two/2x")
    public String two() {
        return "catalog2";
    }

    @GetMapping("/three/2x")
    public String three() {
        return "model2";
    }

    @GetMapping("/table/2x")
    @ResponseBody
    public ResponseEntity<WebResult<List<TableStat>>> tableV2() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException, IOException {
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                new RestTemplate(),
                dataPlatformConfiguration.getAddress(),
                dataPlatformConfiguration.getUserId(),
                AKSK.getCipherText(dataPlatformConfiguration.getPrivateKey())
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String treeBody = restTemplate.exchange(dataPlatformConfiguration.getAddress() + "x-data-resource-service/resources/tables", HttpMethod.GET, request, String.class).getBody();
        assert treeBody != null;
        JSONObject treeJson = new JSONObject(treeBody);
        JSONArray treeData = treeJson.getJSONArray("data");
        int totalElements = treeJson.getInt("totalElements");
        int totalPages = treeJson.getInt("totalPages");
        String allBody = restTemplate.exchange(dataPlatformConfiguration.getAddress() + "x-data-resource-service/resources/tables?pageNumber=1&pageSize=" + totalElements, HttpMethod.GET, request, String.class).getBody();
        assert allBody != null;
        JSONObject allJson = new JSONObject(allBody);
        JSONArray allData = allJson.getJSONArray("data");
        ArrayList<TableDomain2x> tableDomain2xes = new ArrayList<>();
        for (Object allDatum : allData) {
            JSONObject allDatum1 = (JSONObject) allDatum;
            tableDomain2xes.add(new TableDomain2x(allDatum1.getInt("recordCount"), allDatum1.getBoolean("inCatalogs"), allDatum1.getString("name"), allDatum1.getInt("publishStatus")));
        }

        // 构造数据表相关的统计信息 list
        ArrayList<TableStat> list = new ArrayList<>();
        TableStat stg = new TableStat("stg");
        TableStat ods = new TableStat("ods");
        TableStat dwd = new TableStat("dwd");
        TableStat dws = new TableStat("dws");
        TableStat adm = new TableStat("adm");
        TableStat dim = new TableStat("dim");
        TableStat other = new TableStat("其他");
        TableStat all = new TableStat("总共");
        String namePrefix = null;
        for (TableDomain2x tableDomain2x : tableDomain2xes) {
            String name = tableDomain2x.getName().trim();
            if (name.length() < 3) {
                namePrefix = "其他";
            } else {
                namePrefix = name.substring(0, 3);
            }
            Integer recordCount = tableDomain2x.getRecordCount();
            Boolean inCatalogs = tableDomain2x.getInCatalogs();
            Integer publishStatus = tableDomain2x.getPublishStatus();
            switch (namePrefix) {
                case "stg":
                    stg.addTableCount(1);
                    if (recordCount == 0) {
                        stg.addBlankTableCount(1);
                    }
                    if (!inCatalogs) {
                        stg.addUnrelatedTableCount(1);
                    }
                    if (publishStatus != 2) {
                        stg.addUnpublishedTableCount(1);
                    }
                    break;
                case "ods":
                    ods.addTableCount(1);
                    if (recordCount == 0) {
                        ods.addBlankTableCount(1);
                    }
                    if (!inCatalogs) {
                        ods.addUnrelatedTableCount(1);
                    }
                    if (publishStatus != 2) {
                        ods.addUnpublishedTableCount(1);
                    }
                    break;
                case "dwd":
                    dwd.addTableCount(1);
                    if (recordCount == 0) {
                        dwd.addBlankTableCount(1);
                    }
                    if (!inCatalogs) {
                        dwd.addUnrelatedTableCount(1);
                    }
                    if (publishStatus != 2) {
                        dwd.addUnpublishedTableCount(1);
                    }
                    break;
                case "dws":
                    dws.addTableCount(1);
                    if (recordCount == 0) {
                        dws.addBlankTableCount(1);
                    }
                    if (!inCatalogs) {
                        dws.addUnrelatedTableCount(1);
                    }
                    if (publishStatus != 2) {
                        dws.addUnpublishedTableCount(1);
                    }
                    break;
                case "adm":
                    adm.addTableCount(1);
                    if (recordCount == 0) {
                        adm.addBlankTableCount(1);
                    }
                    if (!inCatalogs) {
                        adm.addUnrelatedTableCount(1);
                    }
                    if (publishStatus != 2) {
                        adm.addUnpublishedTableCount(1);
                    }
                    break;
                case "dim":
                    dim.addTableCount(1);
                    if (recordCount == 0) {
                        dim.addBlankTableCount(1);
                    }
                    if (!inCatalogs) {
                        dim.addUnrelatedTableCount(1);
                    }
                    if (publishStatus != 2) {
                        dim.addUnpublishedTableCount(1);
                    }
                    break;
                default:
                    other.addTableCount(1);
                    if (recordCount == 0) {
                        other.addBlankTableCount(1);
                    }
                    if (!inCatalogs) {
                        other.addUnrelatedTableCount(1);
                    }
                    if (publishStatus != 2) {
                        other.addUnpublishedTableCount(1);
                    }
            }
        }
        list.add(stg);
        list.add(ods);
        list.add(dwd);
        list.add(dws);
        list.add(adm);
        list.add(dim);
        list.add(other);
        all.setTableCount(stg.getTableCount() + ods.getTableCount() + dwd.getTableCount() + dws.getTableCount() + adm.getTableCount() + dim.getTableCount() + other.getTableCount());
        all.setBlankTableCount(stg.getBlankTableCount() + ods.getBlankTableCount() + dwd.getBlankTableCount() + dws.getBlankTableCount() + adm.getBlankTableCount() + dim.getBlankTableCount() + other.getBlankTableCount());
        all.setUnrelatedTableCount(stg.getUnrelatedTableCount() + ods.getUnrelatedTableCount() + dwd.getUnrelatedTableCount() + dws.getUnrelatedTableCount() + adm.getUnrelatedTableCount() + dim.getUnrelatedTableCount() + other.getUnrelatedTableCount());
        all.setUnpublishedTableCount(stg.getUnpublishedTableCount() + ods.getUnpublishedTableCount() + dwd.getUnpublishedTableCount() + dws.getUnpublishedTableCount() + adm.getUnpublishedTableCount() + dim.getUnpublishedTableCount() + other.getUnpublishedTableCount());
        list.add(all);
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    /**
     * 数据中台 2.x 版本的资源目录展示方法
     *
     * @return
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeySpecException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @author wangjingdong
     * @date 2021/6/21 14:43
     */
    @GetMapping("/catalog/2x")
    @ResponseBody
    public ResponseEntity<List<TreeObject>> catalog2x() throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                new RestTemplate(),
                dataPlatformConfiguration.getAddress(),
                dataPlatformConfiguration.getUserId(),
                AKSK.getCipherText(dataPlatformConfiguration.getPrivateKey())
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String treeBody = restTemplate
                .exchange(dataPlatformConfiguration.getAddress() + "x-data-resource-service/resource-catalogs?sortByIndex=true&publishStatus=2&pageSize=10000&pageNumber=1",
                        HttpMethod.GET, request, String.class).getBody();
        assert treeBody != null;
        JSONObject treeJson = new JSONObject(treeBody);
        JSONArray treeData = treeJson.getJSONArray("data");
        List<TreeObject> subList = getSubList(null, treeData);
        return ResponseEntity.ok().body(subList);
    }

    /**
     * 获取嵌套的目录列表
     *
     * @param id
     * @param tagData
     * @return
     * @author wangjingdong
     * @date 2021/6/21 17:23
     */
    private List<TreeObject> getSubList(Integer id, JSONArray tagData) {
        ArrayList<TreeObject> childList = new ArrayList<>();
        String pid;

        if (id == null) {
            for (Object tagObject : tagData) {
                JSONObject tag = (JSONObject) tagObject;
                pid = tag.get("parentId").toString();
                if (pid.equals("null")) {
                    childList.add(new TreeObject(tag.getString("name"), tag.getInt("id"), null, null, null, false, false, false));
                }
            }
        } else {
            for (Object tagObject : tagData) {
                JSONObject tag = (JSONObject) tagObject;
                pid = tag.get("parentId").toString();
                if (Integer.toString(id).equals(pid)) {
                    childList.add(new TreeObject(tag.getString("name"), tag.getInt("id"), null, null, null, false, false, false));
                }
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

    @GetMapping("/table/all/2x")
    public ResponseEntity<WebResult<List<DataResourceDto>>> getAllTables(@RequestParam(name = "page") int page,
                                                                         @RequestParam(name = "limit") int limit,
                                                                         @RequestParam(name = "nameEn", defaultValue = "") String nameEn,
                                                                         @RequestParam(name = "field", defaultValue = "status") String field,
                                                                         @RequestParam(name = "order", defaultValue = "asc") String order) throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
        ArrayList<DataResourceDto> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                new RestTemplate(),
                dataPlatformConfiguration.getAddress(),
                dataPlatformConfiguration.getUserId(),
                AKSK.getCipherText(dataPlatformConfiguration.getPrivateKey())
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String body;
        int count = 0;
        if (field.equals("status") && nameEn.equals("")) {
            body = restTemplate
                    .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/resources/tables?pageNum=" + page + "&pageSize=" + limit,
                            HttpMethod.GET, request, String.class).getBody();
            JSONObject tablesJson = new JSONObject(body);
            count = tablesJson.getInt("totalElements");
        } else {
            String tablesBody = restTemplate
                    .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/resources/tables",
                            HttpMethod.GET, request, String.class).getBody();
            JSONObject tablesJson = new JSONObject(tablesBody);
            count = tablesJson.getInt("totalElements");
            body = restTemplate
                    .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/resources/tables?pageNum=1" + "&pageSize=" + count,
                            HttpMethod.GET, request, String.class).getBody();
        }

        JSONObject tablesJson = new JSONObject(body);
        JSONArray tablesJsonArray = tablesJson.getJSONArray("data");
        for (Object o : tablesJsonArray) {
            JSONObject o1 = (JSONObject) o;
            int status = o1.getInt("publishStatus");
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
            String nameEn1 = o1.getString("name");
            if (nameEn.equals("") || nameEn1.contains(nameEn)) {
                list.add(new DataResourceDto(o1.getString("friendlyName"), nameEn1, statusString, o1.getInt("recordCount"), o1.getInt("id"), o1.getString("createTime")));
            }
        }
        if (!field.equals("status")) {
            list.sort(new Comparator<DataResourceDto>() {
                @SneakyThrows
                @Override
                public int compare(DataResourceDto o1, DataResourceDto o2) {
                    if (order.equals("asc")) {
                        switch (field) {
                            case "friendlyName":
                                return o1.getNameCn().compareTo(o2.getNameCn());
                            case "name":
                                return o1.getNameEn().compareTo(o2.getNameEn());
                            case "recordCount":
                                return o1.getCount() - o2.getCount();
                            case "createTime":
                                return o1.getCreateTime().compareTo(o2.getCreateTime());
                            default:
                                throw new Exception();
                        }
                    } else if (order.equals("desc")) {
                        switch (field) {
                            case "friendlyName":
                                return o2.getNameCn().compareTo(o1.getNameCn());
                            case "name":
                                return o2.getNameEn().compareTo(o1.getNameEn());
                            case "recordCount":
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

    /**
     * 获取某个表字段信息
     *
     * @param id
     * @return
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeySpecException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws IOException
     * @author wangjingdong
     * @date 2021/6/22 15:27
     */
    @GetMapping("/table/columns/2x/{id}")
    @ResponseBody
    public ResponseEntity<WebResult<List<ResourceColumnDto>>> getColumns(@PathVariable(name = "id") long id) throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
        ArrayList<ResourceColumnDto> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                new RestTemplate(),
                dataPlatformConfiguration.getAddress(),
                dataPlatformConfiguration.getUserId(),
                AKSK.getCipherText(dataPlatformConfiguration.getPrivateKey())
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        HttpEntity<Object> request = new HttpEntity<>(null, requestHeaders);
        String treeBody = restTemplate
                .exchange(dataPlatformConfiguration.getAddress() + "/x-data-resource-service/resources/tables/" + id + "?returnColumn=true",
                        HttpMethod.GET, request, String.class).getBody();
        JSONObject jsonObject = new JSONObject(treeBody);
        JSONObject data = jsonObject.getJSONObject("data");
        String nameEn = data.getString("name");
        String nameCn = data.getString("friendlyName");
        int order = 1;
        JSONArray resourceColumns = data.getJSONArray("columns");
        for (Object resourceColumn : resourceColumns) {
            JSONObject resourceColumn1 = (JSONObject) resourceColumn;
            list.add(new ResourceColumnDto(
                    nameEn,
                    nameCn,
                    order++,
                    resourceColumn1.getString("name"),
                    resourceColumn1.getString("friendlyName"),
                    resourceColumn1.getString("type"),
                    resourceColumn1.getString("description"),
                    resourceColumn1.getBoolean("partition")
            ));
        }
        return ResponseEntity.ok().body(WebResult.success(list));
    }

    /**
     * 获取某个表数据
     *
     * @param nameEn
     * @return
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeySpecException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IOException
     * @author wangjingdong
     * @date 2021/6/22 15:28
     */
    @GetMapping("/table/2x/{nameEn}")
    @ResponseBody
    public ResponseEntity<WebResult<String>> getData(@PathVariable(name = "nameEn") String nameEn) throws NoSuchPaddingException, IllegalBlockSizeException, InvalidKeySpecException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, SignatureException {
        ArrayList<Object> list = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        String token = AKSK.getToken(
                new RestTemplate(),
                dataPlatformConfiguration.getAddress(),
                dataPlatformConfiguration.getUserId(),
                AKSK.getCipherText(dataPlatformConfiguration.getPrivateKey())
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);
        SqlExecuteDto sqlExecuteDto = new SqlExecuteDto();
//        sqlExecuteDto.setSql("insert into table stg_class values('1','1班','1楼',6)");
        sqlExecuteDto.setSql("select * from " + nameEn);
        sqlExecuteDto.setEngine("mpp");
        sqlExecuteDto.setTimeout(0);
        sqlExecuteDto.setIsIncludeHeaders(false);
        HttpEntity<Object> request = new HttpEntity<>(sqlExecuteDto, requestHeaders);
        byte[] treeBody = restTemplate
                .exchange(dataPlatformConfiguration.getAddress() + "/x-storage-service/storages/sqls/execute",
                        HttpMethod.POST, request, byte[].class).getBody();
        String result = new String(treeBody, StandardCharsets.UTF_8);
        return ResponseEntity.ok().body(WebResult.success(result));
    }
}
