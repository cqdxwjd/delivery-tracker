package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhijun.guo
 * @create 2020-02-07 13:12
 **/

@ApiModel(description = "查询数据表枚举参数对象")
public class QueryDataResEnumDto {

    @ApiModelProperty("标签名称")
    private String nameCn;

    @ApiModelProperty("标签类型")
    private String type;

    @ApiModelProperty("标签类型ID")
    private Long typeId;

    public QueryDataResEnumDto() {
    }

    public QueryDataResEnumDto(String nameCn, String type, Long typeId) {
        this.nameCn = nameCn;
        this.type = type;
        this.typeId = typeId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
