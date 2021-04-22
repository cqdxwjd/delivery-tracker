package com.yunli.bigdata.dsep.service.common.dto.statistics;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author wei
 */
public class DataResourceUsage implements Serializable {
  @ApiModelProperty("数据表英文名")
  private String nameEn;

  @ApiModelProperty("数据表中文名")
  private String nameCn;

  @ApiModelProperty("调用次数")
  private Long times;

  @ApiModelProperty("调用数据量（行数）")
  private Long count;

  @ApiModelProperty("数据表责任组织")
  private String organization;

  @ApiModelProperty("调用者用户ID")
  private String user;

  @ApiModelProperty("调用者组织ID")
  private String userOrganization;

  public DataResourceUsage() {
  }

  public DataResourceUsage(String nameEn, String nameCn, Long times, Long count, String organization,
      String user, String userOrganization) {
    this.nameEn = nameEn;
    this.nameCn = nameCn;
    this.times = times;
    this.count = count;
    this.organization = organization;
    this.user = user;
    this.userOrganization = userOrganization;
  }

  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }

  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }

  public Long getTimes() {
    return times;
  }

  public void setTimes(Long times) {
    this.times = times;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getUserOrganization() {
    return userOrganization;
  }

  public void setUserOrganization(String userOrganization) {
    this.userOrganization = userOrganization;
  }
}
