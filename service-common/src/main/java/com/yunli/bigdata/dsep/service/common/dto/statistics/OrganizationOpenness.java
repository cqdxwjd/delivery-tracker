package com.yunli.bigdata.dsep.service.common.dto.statistics;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author wei
 */
public class OrganizationOpenness implements Serializable {
  @ApiModelProperty("组织ID")
  private String organizationId;

  @ApiModelProperty("组织名称")
  private String organizationName;

  @ApiModelProperty("数据表总量")
  private Long totalCount;

  @ApiModelProperty("数据表发布总量")
  private Long publishedCount;

  @ApiModelProperty("开放性指标")
  private Double openness;

  public OrganizationOpenness() {
  }

  public OrganizationOpenness(String organizationId, String organizationName, Long totalCount,
      Long publishedCount, Double openness) {
    this.organizationId = organizationId;
    this.organizationName = organizationName;
    this.totalCount = totalCount;
    this.publishedCount = publishedCount;
    this.openness = openness;
  }

  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
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

  public Double getOpenness() {
    return openness;
  }

  public void setOpenness(Double openness) {
    this.openness = openness;
  }
}
