package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * FilterDataResourceSampleResponseDto
 * @author wei
 */
@ApiModel(description = "查询数据表参数对象列表")
public class FilterDataResourceSampleResponseDto implements Serializable {
  /**
   * 数据表表ID
   **/
  @ApiModelProperty("数据表表ID")
  private Long id;

  @ApiModelProperty("资源表名称（中文）")
  private String nameCn;

  @ApiModelProperty("资源表名称（英文）")
  private String nameEn;

  public FilterDataResourceSampleResponseDto() {
  }

  public FilterDataResourceSampleResponseDto(Long id, String nameCn, String nameEn) {
    this.id = id;
    this.nameCn = nameCn;
    this.nameEn = nameEn;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }

  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }
}
