package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangjingdong
 * @date 2021/6/23 11:27
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
public class CatalogStat {
    String type;
    Integer treeCount;
    Integer catalogCount;
}
