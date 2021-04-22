package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhijun.guo
 * @create 2020-02-07 11:11
 **/

@ApiModel(description = "添加数据表扩展属性对象")
public class AddDataResExtProDto {

    @ApiModelProperty(value = "扩展属性名称", required = true)
    private String name;

    @ApiModelProperty("扩展属描述")
    private String description;

    @ApiModelProperty(value = "扩展属性分组值", required = true)
    private String groupCode;

    public AddDataResExtProDto() {
    }

    public AddDataResExtProDto(String name, String description, String groupCode) {
        this.name = name;
        this.description = description;
        this.groupCode = groupCode;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
