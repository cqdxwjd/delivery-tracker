package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ApiModel(description = "修改数据源对象")
public class UpdateDataSourceRequest implements Serializable {

//  @ApiModelProperty(value = "数据源类型", required = true)
//  @NotNull(message = "数据源类型不能为空")
//  private String type;
//
//  @ApiModelProperty(value = "数据源名称", required = true)
//  @NotNull(message = "数据源名称不能为空")
//  private String name;

  @ApiModelProperty(value = "数据源描述")
  @Size(max = 200, message = "数据源描述字符数不能超过200")
  private String description;

  @ApiModelProperty(value = "数据源连接信息", required = true)
  @NotBlank(message = "数据源连接信息不能为空")
  @Size(max = 4000, message = "数据源连接信息字符数不能超过4000")
  private String connection;

  public UpdateDataSourceRequest() {
  }

  public UpdateDataSourceRequest(String description, String connection) {
    this.description = description;
    this.connection = connection;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getConnection() {
    return connection;
  }

  public void setConnection(String connection) {
    this.connection = connection;
  }
}
