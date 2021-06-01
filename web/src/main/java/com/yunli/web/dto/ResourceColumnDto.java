package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangjingdong
 * @date 2021/6/1 11:10
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
public class ResourceColumnDto {
    String nameEn;
    String nameCn;
    long order;
    String columnEn;
    String columnCn;
    String type;
    String description;
    boolean isPartition;
}