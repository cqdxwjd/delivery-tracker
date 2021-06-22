package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author wangjingdong
 * @date 2021/6/22 16:08
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SqlExecuteDto {
    private String sql;

    private Integer timeout;

    private String engine;

    private Boolean isIncludeHeaders;

    private Map<String, String> environments;

    private Long databaseId;
}
