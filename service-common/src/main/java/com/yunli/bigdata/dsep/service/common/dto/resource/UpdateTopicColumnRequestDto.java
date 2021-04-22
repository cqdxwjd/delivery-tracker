package com.yunli.bigdata.dsep.service.common.dto.resource;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 添加TOPICColumn信息的参数对象
 * @author wei
 */
@ApiModel(description = "添加TOPICColumn信息的参数对象")
public class UpdateTopicColumnRequestDto implements Serializable {
  private Long id;

  @NotBlank(message = "实时数据信道字段的英文名不能为空")
  @Size(max = 64, message = "实时数据信道字段的英文名字符数不能超过64")
  private String columnName;

  @ApiModelProperty("列类型")
  private String columnType;

  @ApiModelProperty("列排序")
  private Integer sortId;

  @ApiModelProperty("列描述")
  private String columnDescription;

  public UpdateTopicColumnRequestDto() {
  }

  public UpdateTopicColumnRequestDto(Long id, String columnName, String columnType,
      String columnDescription, Integer sortId) {
    this.id = id;
    this.columnName = columnName;
    this.columnType = columnType;
    this.columnDescription = columnDescription;
    this.sortId = sortId;
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

  public Integer getSortId() {
    return sortId;
  }

  public void setSortId(Integer sortId) {
    this.sortId = sortId;
  }
}
