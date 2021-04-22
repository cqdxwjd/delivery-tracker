package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "查询底座信息响应")
public class FoundationResponse implements Serializable {

  private String type;

  private String connection;

  public FoundationResponse() {
  }

  public FoundationResponse(String type, String connection) {
    this.type = type;
    this.connection = connection;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getConnection() {
    return connection;
  }

  public void setConnection(String connection) {
    this.connection = connection;
  }
}
