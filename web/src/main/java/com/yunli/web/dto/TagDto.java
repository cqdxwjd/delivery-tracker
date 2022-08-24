package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author wangjingdong
 * @date 2021/6/24 16:12
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
public class TagDto {
    Integer keyId;
    List<String> values;
}
