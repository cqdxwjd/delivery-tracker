package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhangws
 */
@ApiModel(description = "资源目录高级检索的检索条件响应")
public class QueryConditionOption implements Serializable {
  @ApiModelProperty("编码")
  private Object code;

  @ApiModelProperty("名称")
  private String name;

  public QueryConditionOption() {
  }

  public QueryConditionOption(Object code, String name) {
    this.code = code;
    this.name = name;
  }

  public Object getCode() {
    return code;
  }

  public void setCode(Object code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
