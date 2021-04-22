package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhijun.guo
 * @create 2020-02-07 13:12
 **/

@ApiModel(description = "查询数据表扩展属性参数对象")
public class QueryDataResExtProDto {


    @ApiModelProperty(value = "扩展属性名称")
    private String nameCn;

    @ApiModelProperty(value = "是否已关联标签")
    private Boolean hasLabel;

    @ApiModelProperty(value = "属性声明分组编码值")
    private String groupCode;

    public QueryDataResExtProDto() {
    }

    public QueryDataResExtProDto(String nameCn, Boolean hasLabel, String groupCode) {
        this.nameCn = nameCn;
        this.hasLabel = hasLabel;
        this.groupCode = groupCode;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public Boolean getHasLabel() {
        return hasLabel;
    }

    public void setHasLabel(Boolean hasLabel) {
        this.hasLabel = hasLabel;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
