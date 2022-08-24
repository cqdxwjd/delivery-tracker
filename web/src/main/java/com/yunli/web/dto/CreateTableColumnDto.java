package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangjingdong
 * @date 2021/6/24 16:09
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
public class CreateTableColumnDto {
    String description;
    String friendlyName;
    Integer length;
    String name;
    Boolean partition;
    String type;
}
