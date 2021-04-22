package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "添加数据源对象")
public class ConnectivityRequest implements Serializable {

  @ApiModelProperty(value = "数据源类型", required = true)
  @NotBlank(message = "数据源类型不能为空")
  @Size(max = 30, message = "数据源类型字符数不能超过30")
  private String type;

  @ApiModelProperty(value = "数据源连接信息", required = true)
  @NotBlank(message = "数据源连接不能为空")
  @Size(max = 4000, message = "数据源连接信息字符数不能超过4000")
  private String connection;

  public ConnectivityRequest() {
  }

  public ConnectivityRequest(String type, String connection) {
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
