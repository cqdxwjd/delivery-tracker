package com.yunli.bigdata.dsep.service.common.dto.resource;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 添加主题Column信息的参数对象
 * @author wei
 */
@ApiModel(description = "添加TOPICColumn信息的参数对象")
public class AddTopicColumnRequestDto implements Serializable {
  /**
   * 字段名称
   **/
  @ApiModelProperty("字段名称")
  @NotNull(message = "字段名称不能为空")
  @Size(max = 64, message = "实时数据信道字段的英文名字符数不能超过64")
  private String columnName;

  /**
   * 字段类型
   **/
  @ApiModelProperty("字段类型")
  @NotNull(message = "字段类型不能为空")
  private String columnType;


  @ApiModelProperty("字段顺序")
  private Integer sortId;

  /**
   * 字段描述
   **/
  @ApiModelProperty("字段描述")
  private String columnDescription;

  public AddTopicColumnRequestDto() {
  }

  public AddTopicColumnRequestDto(String columnName, String columnType, String columnDescription, Integer sortId) {
    this.columnName = columnName;
    this.columnType = columnType;
    this.columnDescription = columnDescription;
    this.sortId = sortId;
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


  public Integer getSortId() {
    return sortId;
  }

  public void setSortId(Integer sortId) {
    this.sortId = sortId;
  }
}
