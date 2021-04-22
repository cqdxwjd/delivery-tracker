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
public class QueryDataAccessLogDto implements Serializable {
  @ApiModelProperty("资源调用者ID")
  private String userId;

  @ApiModelProperty("资源调用者名称")
  private String userName;

  @ApiModelProperty("资源调用组织机构名称")
  private String userOrganizationName;

  @ApiModelProperty("资源类型(data)")
  private String resourceType;

  @ApiModelProperty("资源ID")
  private Long resourceId;

  @ApiModelProperty("资源类型名称(英文)")
  private String name;

  @ApiModelProperty("文件名称")
  private String fileName;

  @ApiModelProperty("资源类型名称")
  private String organizationResponsible;

  @ApiModelProperty("资源责任组织名称")
  private String organizationResponsibleName;

  @ApiModelProperty("访问状态 0-成功, 1-失败")
  private Long status;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("开始时间")
  private Date startTime;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("结束时间")
  private Date endTime;

  public QueryDataAccessLogDto() {
  }

  public QueryDataAccessLogDto(String userId, String userName, String userOrganizationName, String resourceType,
      Long resourceId, String name, String fileName, String organizationResponsible, String organizationResponsibleName,
      Long status, Date startTime, Date endTime) {
    this.userId = userId;
    this.userName = userName;
    this.userOrganizationName = userOrganizationName;
    this.resourceType = resourceType;
    this.resourceId = resourceId;
    this.name = name;
    this.fileName = fileName;
    this.organizationResponsible = organizationResponsible;
    this.organizationResponsibleName = organizationResponsibleName;
    this.status = status;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserOrganizationName() {
    return userOrganizationName;
  }

  public void setUserOrganizationName(String userOrganizationName) {
    this.userOrganizationName = userOrganizationName;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getOrganizationResponsible() {
    return organizationResponsible;
  }

  public void setOrganizationResponsible(String organizationResponsible) {
    this.organizationResponsible = organizationResponsible;
  }

  public String getOrganizationResponsibleName() {
    return organizationResponsibleName;
  }

  public void setOrganizationResponsibleName(String organizationResponsibleName) {
    this.organizationResponsibleName = organizationResponsibleName;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
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
