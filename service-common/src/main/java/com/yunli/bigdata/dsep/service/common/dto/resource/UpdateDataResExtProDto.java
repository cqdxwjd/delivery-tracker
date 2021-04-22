package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhijun.guo
 * @create 2020-02-07 11:11
 **/

@ApiModel(description = "添加数据表扩展属性对象")
public class UpdateDataResExtProDto {

    @ApiModelProperty(value = "扩展属性名称")
    private String name;

    @ApiModelProperty("扩展属描述")
    private String description;

    public UpdateDataResExtProDto() {
    }

    public UpdateDataResExtProDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
