package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangjingdong
 * @date 2021/5/31 09:33
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
public class DataResourceDto {
    String nameCn;
    String nameEn;
    String status;
    int count;
    int id;
    String createTime;
}
