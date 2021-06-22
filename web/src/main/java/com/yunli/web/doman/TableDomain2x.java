package com.yunli.web.doman;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangjingdong
 * @date 2021/6/22 13:52
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
public class TableDomain2x {
    Integer recordCount;
    Boolean inCatalogs;
    String name;
    Integer publishStatus;
}