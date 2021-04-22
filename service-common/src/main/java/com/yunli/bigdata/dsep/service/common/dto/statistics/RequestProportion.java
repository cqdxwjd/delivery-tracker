package com.yunli.bigdata.dsep.service.common.dto.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guozhijun
 * @date 2020/2/29 0029
 */

@ApiModel(description = "饼状图或状态值信息")
public class RequestProportion {

    @ApiModelProperty("类别")
    private String type;

    @ApiModelProperty("值")
    private Double value;

    public RequestProportion() {
    }

    public RequestProportion(String type, Double value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
