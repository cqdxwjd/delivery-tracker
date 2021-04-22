package com.yunli.bigdata.dsep.service.common.dto.resource;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加数据表Column信息的参数对象
 * @author wei
 */
@ApiModel(description = "添加数据表Column信息的参数对象")
public class UpdateResourceColumnRequestDto implements Serializable {
  private Long id;
  @NotBlank(message = "数据表字段的英文名不能为空")
  @Size(max = 64, message = "数据表字段的英文名字符数不能超过64")
  private String columnName;

  private String columnType;

  private String columnDescription;

  private boolean partitionColumn;

  private boolean secret;

  public UpdateResourceColumnRequestDto() {
  }

  public UpdateResourceColumnRequestDto(Long id, String columnName, String columnType,
      String columnDescription, boolean partitionColumn, boolean secret) {
    this.id = id;
    this.columnName = columnName;
    this.columnType = columnType;
    this.columnDescription = columnDescription;
    this.partitionColumn = partitionColumn;
    this.secret = secret;
  }

  /**
   * 字段名称
   * @return columnName
   **/
  @ApiModelProperty("字段名称")
  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }


  /**
   * 字段类型
   * @return columnType
   **/
  @ApiModelProperty("字段类型")
  public String getColumnType() {
    return columnType;
  }

  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }


  /**
   * 字段描述
   * @return columnDescription
   **/
  @ApiModelProperty("字段描述")
  public String getColumnDescription() {
    return columnDescription;
  }

  public void setColumnDescription(String columnDescription) {
    this.columnDescription = columnDescription;
  }

  /**
   * 是否分区字段
   * @return partitionColumn
   **/
  @ApiModelProperty("是否分区字段")
  public boolean isPartitionColumn() {
    return partitionColumn;
  }

  public void setPartitionColumn(boolean partitionColumn) {
    this.partitionColumn = partitionColumn;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 是否涉密
   * @return secret
   **/
  @ApiModelProperty("是否涉密")
  public boolean getSecret() {
    return secret;
  }

  public void setSecret(boolean secret) {
    this.secret = secret;
  }
}
