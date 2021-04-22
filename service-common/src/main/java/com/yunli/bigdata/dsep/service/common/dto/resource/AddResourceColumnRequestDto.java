package com.yunli.bigdata.dsep.service.common.dto.resource;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加数据表Column信息的参数对象
 * @author wei
 */
@ApiModel(description = "添加数据表Column信息的参数对象")
public class AddResourceColumnRequestDto implements Serializable {
  /**
   * 字段名称
   **/
  @ApiModelProperty("字段名称")
  @NotNull(message = "字段名称不能为空")
  @Size(max = 64, message = "数据表字段的英文名字符数不能超过64")
  private String columnName;

  /**
   * 字段类型
   **/
  @ApiModelProperty("字段类型")
  @NotNull(message = "字段类型不能为空")
  private String columnType;

  /**
   * 字段描述
   **/
  @ApiModelProperty("字段描述")
  private String columnDescription;

  /**
   * 是否分区字段
   **/
  @ApiModelProperty("是否分区字段(默认false)")
  private Boolean partitionColumn = false;

  /**
   * 是否涉密
   **/
  @ApiModelProperty("是否涉密(默认false)")
  private Boolean secret = false;

  public AddResourceColumnRequestDto() {
  }

  public AddResourceColumnRequestDto(String columnName, String columnType, String columnDescription) {
    this.columnName = columnName;
    this.columnType = columnType;
    this.columnDescription = columnDescription;
  }

  public AddResourceColumnRequestDto(String columnName, String columnType, String columnDescription,
      Boolean partitionColumn) {
    this.columnName = columnName;
    this.columnType = columnType;
    this.columnDescription = columnDescription;
    this.partitionColumn = partitionColumn;
  }


  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }


  public String getColumnType() {
    return columnType;
  }

  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }


  public String getColumnDescription() {
    return columnDescription;
  }

  public void setColumnDescription(String columnDescription) {
    this.columnDescription = columnDescription;
  }


  public Boolean getPartitionColumn() {
    return partitionColumn;
  }

  public void setPartitionColumn(Boolean partitionColumn) {
    this.partitionColumn = partitionColumn;
  }


  public Boolean getSecret() {
    return secret;
  }

  public void setSecret(Boolean secret) {
    this.secret = secret;
  }
}
