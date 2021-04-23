package com.yunli.web.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.yunli.bigdata.dsep.foundation.util.JsonUtil;
import com.yunli.web.dto.TableStat;
import com.yunli.web.service.DataResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class DataResourceController {

    private final DataResourceService dataResourceService;

    @Autowired
    public DataResourceController(DataResourceService dataResourceService) {
        this.dataResourceService = dataResourceService;
    }

    @RequestMapping("/test.html")
    public String test(Model model) {
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
        return "test";
    }

    // 动态渲染时使用
//    @RequestMapping("/result")
//    @ResponseBody
//    public String result() {
//        ArrayList<TableStat> list = new ArrayList<>();
//        TableStat tableStat = new TableStat();
//        tableStat.setTableCount(dataResourceService.getTableCount());
//        tableStat.setBlankTableCount(dataResourceService.getBlankTableCount());
//        tableStat.setUnrelatedTableCount(dataResourceService.getUnrelatedTableCount());
//        tableStat.setUnpublishedTableCount(dataResourceService.getUnpublishedTableCount());
//        list.add(tableStat);
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", 0);
//        map.put("msg", "");
//        map.put("data", list);
//        map.put("count", 1);
//        return JSONObject.valueToString(map);
//    }
}
