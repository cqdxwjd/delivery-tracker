package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * FilterPublishedResourceResponse
 * @author wei
 */
@ApiModel(description = "查询资源列表返回结果")
public class FilterPublishedResourceResponse implements Serializable {
  @ApiModelProperty("资源类型（数据表:data 文件夹:document）")
  private String type;

  @ApiModelProperty("资源详情")
  private Object resource;

  public FilterPublishedResourceResponse() {
  }

  public FilterPublishedResourceResponse(String type, Object resource) {
    this.type = type;
    this.resource = resource;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Object getResource() {
    return resource;
  }

  public void setResource(Object resource) {
    this.resource = resource;
  }
}
