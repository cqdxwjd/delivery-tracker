package com.yunli.bigdata.dsep.service.common.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "添加数据访问审计日志参数对象")
public class AddDataAccessLogDto implements Serializable {
  @ApiModelProperty("资源调用者ID")
  private String userId;

  @ApiModelProperty("资源调用者名称")
  private String userName;

  @ApiModelProperty("资源调用者组织名称")
  private String userOrganizationName;

  @ApiModelProperty("调用方式（api、job、download）")
  private String type;

  @ApiModelProperty("资源类型(data、file)")
  private String resourceType;

  @ApiModelProperty("资源ID")
  private Long resourceId;

  @ApiModelProperty("资源表名称（英文）")
  private String name;

  @ApiModelProperty("文件夹ID")
  private String fileName;

  @ApiModelProperty("责任组织ID")
  private String organizationResponsible;

  @ApiModelProperty("责任组织名称")
  private String organizationResponsibleName;

  @ApiModelProperty("访问状态 0-成功, 1-失败")
  private Integer status;

  @ApiModelProperty("访问结果数量")
  private Long count;

  @ApiModelProperty("访问失败原因")
  private String reason;

  @ApiModelProperty("生成时间")
  private Date createTime;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
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

  public AddDataAccessLogDto() {
  }

  public AddDataAccessLogDto(String userId, String userName, String userOrganizationName, String type,
      String resourceType, Long resourceId, String name, String fileName, String organizationResponsible,
      String organizationResponsibleName, Integer status, Long count, String reason) {
    this.userId = userId;
    this.userName = userName;
    this.userOrganizationName = userOrganizationName;
    this.type = type;
    this.resourceType = resourceType;
    this.resourceId = resourceId;
    this.name = name;
    this.fileName = fileName;
    this.organizationResponsible = organizationResponsible;
    this.organizationResponsibleName = organizationResponsibleName;
    this.status = status;
    this.count = count;
    this.reason = reason;
    this.createTime = new Date();
  }

  @Override
  public String toString() {
    return "AddDataAccessLogDto{" +
        "userId='" + userId + '\'' +
        ", userName='" + userName + '\'' +
        ", userOrganizationName='" + userOrganizationName + '\'' +
        ", type='" + type + '\'' +
        ", resourceType='" + resourceType + '\'' +
        ", resourceId=" + resourceId +
        ", name='" + name + '\'' +
        ", documentId=" + fileName +
        ", organizationResponsible='" + organizationResponsible + '\'' +
        ", organizationResponsibleName='" + organizationResponsibleName + '\'' +
        ", status=" + status +
        ", count=" + count +
        ", reason='" + reason + '\'' +
        ", createTime=" + createTime +
        '}';
  }
}
