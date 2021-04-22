package com.yunli.web.controller;

import com.yunli.web.service.DataResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DataResourceController {

    private final DataResourceService dataResourceService;

    @Autowired
    public DataResourceController(DataResourceService dataResourceService) {
        this.dataResourceService = dataResourceService;
    }

    @RequestMapping("/test.html")
    public String test(HttpServletRequest request) {
        Long tableCount = dataResourceService.getTableCount();
        request.setAttribute("tableCount", tableCount);
        return "test";
    }
}
