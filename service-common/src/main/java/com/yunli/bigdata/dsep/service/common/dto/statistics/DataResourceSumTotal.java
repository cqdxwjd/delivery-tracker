package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wei
 */
public class DataResourceSumTotal implements Serializable {
  @ApiModelProperty("数据总量")
  private Long dataCount;

  @ApiModelProperty("数据表总量")
  private Long totalCount;

  @ApiModelProperty("数据表发布总量")
  private Long publishedCount;

  @ApiModelProperty("数据表共享次数")
  private Long sharingTimes;

  @ApiModelProperty("来源部门数")
  private Long organizationCount;

  public DataResourceSumTotal() {
  }

  public DataResourceSumTotal(Long dataCount, Long totalCount, Long publishedCount, Long sharingTimes,
      Long organizationCount) {
    this.dataCount = dataCount;
    this.totalCount = totalCount;
    this.publishedCount = publishedCount;
    this.sharingTimes = sharingTimes;
    this.organizationCount = organizationCount;
  }

  public Long getDataCount() {
    return dataCount;
  }

  public void setDataCount(Long dataCount) {
    this.dataCount = dataCount;
  }

  public Long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  public Long getPublishedCount() {
    return publishedCount;
  }

  public void setPublishedCount(Long publishedCount) {
    this.publishedCount = publishedCount;
  }

  public Long getSharingTimes() {
    return sharingTimes;
  }

  public void setSharingTimes(Long sharingTimes) {
    this.sharingTimes = sharingTimes;
  }

  public Long getOrganizationCount() {
    return organizationCount;
  }

  public void setOrganizationCount(Long organizationCount) {
    this.organizationCount = organizationCount;
  }
}
