package com.yunli.bigdata.dsep.service.common.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "查询数据访问审计日志参数对象")
public class QueryDataAccessLogGroupByDataResourceDto implements Serializable {
  @ApiModelProperty("资源名称")
  private String name;

  @ApiModelProperty("资源名称中文")
  private String resourceType;

  @ApiModelProperty("资源提供方")
  private String organizationName;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("开始时间")
  private Date startTime;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("结束时间")
  private Date endTime;

  public QueryDataAccessLogGroupByDataResourceDto() {
  }

  public QueryDataAccessLogGroupByDataResourceDto(String name, String resourceType, String organizationName,
      Date startTime, Date endTime) {
    this.name = name;
    this.resourceType = resourceType;
    this.organizationName = organizationName;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
}
