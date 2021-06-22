package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangjingdong
 * @date 2021/6/21 15:11
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
public class LoginDto {
    private String name;
    private String password;
    private String type;
}
