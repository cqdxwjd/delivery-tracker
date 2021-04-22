package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangws
 */
@ApiModel(description = "资源目录高级检索的检索条件响应")
public class QueryCondition implements Serializable {
  @ApiModelProperty("类型")
  private String type;

  @ApiModelProperty("选项")
  private List<QueryConditionOption> options;

  public QueryCondition() {
  }

  public QueryCondition(String type, List<QueryConditionOption> options) {
    this.type = type;
    this.options = options;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<QueryConditionOption> getOptions() {
    return options;
  }

  public void setOptions(List<QueryConditionOption> options) {
    this.options = options;
  }
}
