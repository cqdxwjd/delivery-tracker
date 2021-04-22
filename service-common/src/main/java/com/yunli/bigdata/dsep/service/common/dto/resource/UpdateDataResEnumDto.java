package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhijun.guo
 * @create 2020-02-07 11:11
 **/

@ApiModel(description = "添加数据表枚举对象")
public class UpdateDataResEnumDto {

    @ApiModelProperty(value = "枚举ID",hidden = true)
    private Long id;

    @ApiModelProperty("枚举名称")
    private String name;

    @ApiModelProperty("枚举类型ID，较枚举类型名称优先识别")
    private Long typeId;

    @ApiModelProperty("枚举描述")
    private String description;

    public UpdateDataResEnumDto() {
    }

    public UpdateDataResEnumDto(Long id, String name, Long typeId, String description) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
