package com.yunli.bigdata.dsep.service.common.dto.resource;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author wei
 */
public class FilterApplicationDto {
  @ApiModelProperty("流程ID")
  private String processInstanceId;

  @ApiModelProperty("标题")
  private String title;

  @ApiModelProperty("申请者ID")
  private String userId;

  @ApiModelProperty("申请者名称")
  private String userName;

  @ApiModelProperty("申请者组织ID")
  private String organizationId;

  @ApiModelProperty("申请者组织名称")
  private String organizationName;

  @ApiModelProperty("申请类型(资源发布申请、资源访问申请)")
  private String approvalType;

  @ApiModelProperty("资源ID")
  private Long resourceId;

  @ApiModelProperty("资源名称")
  private String resourceName;

  @ApiModelProperty("资源类型")
  private String resourceType;

  @ApiModelProperty("申请原因")
  private String reason;

  @ApiModelProperty("申请时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date applicationTime;

  @ApiModelProperty("审批状态(审批中:0 通过:1 未通过:2 撤回授权:3)")
  private Integer approvalStatus;

  @ApiModelProperty("审批者")
  private String approver;

  @ApiModelProperty("审批者名称")
  private String approverName;

  @ApiModelProperty("审批时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date approvalTime;

  @ApiModelProperty("审批意见")
  private String answer;

  @ApiModelProperty("收回权限的操作者ID")
  private String withdrawUser;

  @ApiModelProperty("收回权限的操作者名称")
  private String withdrawUserName;

  @ApiModelProperty("收回权限的时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date withdrawTime;

  public FilterApplicationDto() {
  }

  public FilterApplicationDto(String processInstanceId, String title, String userId, String userName,
      String organizationId, String organizationName, String approvalType, Long resourceId, String resourceName,
      String resourceType, String reason, Integer approvalStatus, String answer, String approver, String approverName,
      Date applicationTime, Date approvalTime, String withdrawUser, String withdrawUserName, Date withdrawTime) {
    this.processInstanceId = processInstanceId;
    this.title = title;
    this.userId = userId;
    this.userName = userName;
    this.organizationId = organizationId;
    this.organizationName = organizationName;
    this.approvalType = approvalType;
    this.resourceId = resourceId;
    this.resourceName = resourceName;
    this.resourceType = resourceType;
    this.reason = reason;
    this.approvalStatus = approvalStatus;
    this.answer = answer;
    this.approver = approver;
    this.approverName = approverName;
    this.applicationTime = applicationTime;
    this.approvalTime = approvalTime;
    this.withdrawUser = withdrawUser;
    this.withdrawUserName = withdrawUserName;
    this.withdrawTime = withdrawTime;
  }

  public String getProcessInstanceId() {
    return processInstanceId;
  }

  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public Integer getApprovalStatus() {
    return approvalStatus;
  }

  public void setApprovalStatus(Integer approvalStatus) {
    this.approvalStatus = approvalStatus;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public String getApprover() {
    return approver;
  }

  public void setApprover(String approver) {
    this.approver = approver;
  }

  public String getApproverName() {
    return approverName;
  }

  public void setApproverName(String approverName) {
    this.approverName = approverName;
  }

  public Date getApplicationTime() {
    return applicationTime;
  }

  public void setApplicationTime(Date applicationTime) {
    this.applicationTime = applicationTime;
  }

  public Date getApprovalTime() {
    return approvalTime;
  }

  public void setApprovalTime(Date approvalTime) {
    this.approvalTime = approvalTime;
  }

  public String getWithdrawUser() {
    return withdrawUser;
  }

  public void setWithdrawUser(String withdrawUser) {
    this.withdrawUser = withdrawUser;
  }

  public String getWithdrawUserName() {
    return withdrawUserName;
  }

  public void setWithdrawUserName(String withdrawUserName) {
    this.withdrawUserName = withdrawUserName;
  }

  public Date getWithdrawTime() {
    return withdrawTime;
  }

  public void setWithdrawTime(Date withdrawTime) {
    this.withdrawTime = withdrawTime;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  @Override
  public String toString() {
    return "FilterApplicationDto{" +
        "processInstanceId='" + processInstanceId + '\'' +
        ", title='" + title + '\'' +
        ", userId='" + userId + '\'' +
        ", userName='" + userName + '\'' +
        ", organizationId='" + organizationId + '\'' +
        ", organizationName='" + organizationName + '\'' +
        ", approvalType='" + approvalType + '\'' +
        ", resourceId=" + resourceId +
        ", resourceName='" + resourceName + '\'' +
        ", resourceType='" + resourceType + '\'' +
        ", reason='" + reason + '\'' +
        ", applicationTime=" + applicationTime +
        ", approvalStatus=" + approvalStatus +
        ", approver='" + approver + '\'' +
        ", approverName='" + approverName + '\'' +
        ", approvalTime=" + approvalTime +
        ", answer='" + answer + '\'' +
        ", withdrawUser='" + withdrawUser + '\'' +
        ", withdrawUserName='" + withdrawUserName + '\'' +
        ", withdrawTime=" + withdrawTime +
        '}';
  }
}
