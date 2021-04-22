package com.yunli.bigdata.dsep.service.common.dto.audit;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "查询数据访问审计日志参数对象")
public class FilterDataAccessLogGroupByDataResourceDto implements Serializable {
  @ApiModelProperty("资源ID")
  private Long resourceId;

  @ApiModelProperty("英文名称")
  private String name;

  @ApiModelProperty("资源类型")
  private String resourceType;

  @ApiModelProperty("资源提供方")
  private String organizationName;

  @ApiModelProperty("被调用次数")
  private Long times;

  public FilterDataAccessLogGroupByDataResourceDto() {
  }

  public FilterDataAccessLogGroupByDataResourceDto(Long resourceId, String name, String resourceType,
      String organizationName, Long times) {
    this.resourceId = resourceId;
    this.name = name;
    this.resourceType = resourceType;
    this.organizationName = organizationName;
    this.times = times;
  }

  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public Long getTimes() {
    return times;
  }

  public void setTimes(Long times) {
    this.times = times;
  }
}
