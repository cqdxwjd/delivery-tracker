package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(description = "数据源对象")
public class DataSourceDto implements Serializable {
  @ApiModelProperty(value = "数据源ID")
  private Long id;

  @ApiModelProperty(value = "数据源名称", required = true)
  @NotNull(message = "数据源类型不能为空")
  private String type;

  @ApiModelProperty(value = "数据源名称", required = true)
  @NotNull(message = "数据源名称不能为空")
  private String name;

  @ApiModelProperty(value = "数据源描述")
  private String description;

  @ApiModelProperty(value = "数据源连接信息", required = true)
  @NotNull(message = "数据源连接不能为空")
  private String connection;

  public DataSourceDto() {
  }

  public DataSourceDto(Long id, String type, String name, String description, String connection) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.description = description;
    this.connection = connection;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
