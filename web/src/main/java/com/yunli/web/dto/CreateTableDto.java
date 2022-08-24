package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangjingdong
 * @date 2021/6/24 16:06
 * @Copyright © 云粒智慧 2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTableDto {
    List<CreateTableColumnDto> columns;
    String description;
    String friendlyName;
    String name;
    String responsibleOrganizationId;
    String responsiblePersonId;
    List<TagDto> tags;
}
