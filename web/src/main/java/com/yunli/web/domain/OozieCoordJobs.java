package com.yunli.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OozieCoordJobs {
    private String appName;
    private String status;
}
