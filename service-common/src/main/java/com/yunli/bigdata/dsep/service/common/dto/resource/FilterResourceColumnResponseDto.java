package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * FilterResourceColumnResponseDto
 * @author wei
 */

public class FilterResourceColumnResponseDto implements Serializable {
  private Long id;

  private Long resourceId;

  private String columnName;

  private String columnType;

  private String columnDescription;

  private Boolean partitionColumn;

  private Boolean secret;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  public FilterResourceColumnResponseDto() {
  }

  public FilterResourceColumnResponseDto(Long id, Long resourceId, String columnName, String columnType,
      String columnDescription, Boolean partitionColumn, Boolean secret, Date createTime, Date updateTime) {
    this.id = id;
    this.resourceId = resourceId;
    this.columnName = columnName;
    this.columnType = columnType;
    this.columnDescription = columnDescription;
    this.partitionColumn = partitionColumn;
    this.secret = secret;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  /**
   * 字段ID
   * @return id
   **/
  @ApiModelProperty("字段ID")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 数据表表ID
   * @return resourceId
   **/
  @ApiModelProperty("数据表表ID")
  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
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
  public Boolean getPartitionColumn() {
    return partitionColumn;
  }

  public void setPartitionColumn(Boolean partitionColumn) {
    this.partitionColumn = partitionColumn;
  }

  /**
   * 是否涉密
   * @return secret
   **/
  @ApiModelProperty("是否涉密")
  public Boolean getSecret() {
    return secret;
  }

  public void setSecret(Boolean secret) {
    this.secret = secret;
  }

  /**
   * 创建时间
   * @return createTime
   **/
  @ApiModelProperty("创建时间")
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 更新时间
   * @return updateTime
   **/
  @ApiModelProperty("更新时间")
  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
