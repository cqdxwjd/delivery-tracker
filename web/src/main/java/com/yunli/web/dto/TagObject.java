package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangjingdong
 * @date 2021/5/28 14:50
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
public class TagObject {
    Long id;
    Long pid;
    String name;
    Long tid;
}
