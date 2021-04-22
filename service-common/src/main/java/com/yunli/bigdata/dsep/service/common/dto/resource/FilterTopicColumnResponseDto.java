package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * FilterTopicColumnResponseDto
 * @author david
 */
@ApiModel(description = "实时数据信道各个SCHEMA信息列表")
public class FilterTopicColumnResponseDto implements Serializable {
  @ApiModelProperty("列编码")
  private Long id;
  @ApiModelProperty("实时数据信道编码")
  private Long topicId;
  @ApiModelProperty("列名称")
  private String columnName;
  @ApiModelProperty("列类型")
  private String columnType;
  @ApiModelProperty("列顺序")
  private Integer sortId;
  @ApiModelProperty("列描述")
  private String columnDescription;
  @ApiModelProperty("创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
  @ApiModelProperty("更新时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  public FilterTopicColumnResponseDto() {
  }

  public FilterTopicColumnResponseDto(Long id, Long topicId, String columnName, String columnType) {
    this.id = id;
    this.topicId = topicId;
    this.columnName = columnName;
    this.columnType = columnType;
  }

  public FilterTopicColumnResponseDto(Long id, Long topicId, String columnName, String columnType, Integer sortId,
      String columnDescription,  Date createTime, Date updateTime) {
    this.id = id;
    this.topicId = topicId;
    this.columnName = columnName;
    this.columnType = columnType;
    this.sortId = sortId;
    this.columnDescription = columnDescription;
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

  public Long getTopicId() {
    return topicId;
  }

  public void setTopicId(Long topicId) {
    this.topicId = topicId;
  }

  public Integer getSortId() {
    return sortId;
  }

  public void setSortId(Integer sortId) {
    this.sortId = sortId;
  }
}
