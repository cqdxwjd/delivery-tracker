package com.yunli.bigdata.dsep.service.common.dto.resource;


import java.util.Objects;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wei
 */
public class AddApplicationDto {
  @ApiModelProperty("申请者ID")
  @NotNull(message = "申请者ID不能为空")
  private String userId;

  @ApiModelProperty("申请者名称")
  private String userName;

  @ApiModelProperty("申请者组织ID")
  @NotNull(message = "申请者组织ID不能为空")
  private String organizationId;

  @ApiModelProperty("申请者组织名称")
  private String organizationName;

  @ApiModelProperty("申请类型(数据表访问申请、文件夹访问申请)")
  @NotNull(message = "申请类型不能为空")
  private String approvalType;

  @ApiModelProperty("资源ID")
  @NotNull(message = "资源ID不能为空")
  private Long resourceId;

  @ApiModelProperty("资源名称")
  private String resourceName;

  @ApiModelProperty("申请原因")
  private String reason;

  public AddApplicationDto() {
  }

  public AddApplicationDto(@NotNull(message = "申请者ID不能为空") String userId,
      @NotNull(message = "申请者组织ID不能为空") String organizationId,
      @NotNull(message = "申请类型不能为空") String approvalType,
      @NotNull(message = "资源ID不能为空") Long resourceId) {
    this.userId = userId;
    this.organizationId = organizationId;
    this.approvalType = approvalType;
    this.resourceId = resourceId;
  }

  public AddApplicationDto(@NotNull(message = "申请者ID不能为空") String userId, String userName,
      @NotNull(message = "申请者组织ID不能为空") String organizationId, String organizationName,
      @NotNull(message = "申请类型不能为空") String approvalType,
      @NotNull(message = "资源ID不能为空") Long resourceId,
      String reason) {
    this.userId = userId;
    this.userName = userName;
    this.organizationId = organizationId;
    this.organizationName = organizationName;
    this.approvalType = approvalType;
    this.resourceId = resourceId;
    this.reason = reason;
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

  public String getApprovalType() {
    return approvalType;
  }

  public void setApprovalType(String approvalType) {
    this.approvalType = approvalType;
  }

  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddApplicationDto that = (AddApplicationDto) o;
    return Objects.equals(userId, that.userId) &&
        Objects.equals(organizationId, that.organizationId) &&
        Objects.equals(approvalType, that.approvalType) &&
        Objects.equals(resourceId, that.resourceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, organizationId, approvalType, resourceId);
  }

  @Override
  public String toString() {
    return "AddApplicationDto{" +
        "userId='" + userId + '\'' +
        ", userName='" + userName + '\'' +
        ", organizationId='" + organizationId + '\'' +
        ", organizationName='" + organizationName + '\'' +
        ", approvalType='" + approvalType + '\'' +
        ", resourceId=" + resourceId +
        ", resourceName='" + resourceName + '\'' +
        ", reason='" + reason + '\'' +
        '}';
  }
}
