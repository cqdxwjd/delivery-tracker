package com.yunli.bigdata.dsep.service.common.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "系统操作审计日志")
public class AddSystemOperationLogDto implements Serializable {
  /**
   * 资源调用者ID
   */
  @ApiModelProperty("资源调用者ID")
  private String userId;

  @ApiModelProperty("资源调用者名称")
  private String userName;

  @ApiModelProperty("资源调用者组织名称")
  private String userOrganizationName;

  /**
   * 资源类型(data、datatag、organization、group、role、user)
   */
  @ApiModelProperty("资源类型(data、datatag、organization、group、role、user)")
  private String resourceType;

  /**
   * 资源ID
   */
  @ApiModelProperty("资源ID")
  private String resourceId;

  /**
   * 资源ID
   */
  @ApiModelProperty("资源名称")
  private String resourceName;

  /**
   * 操作
   */
  @ApiModelProperty("操作")
  private String action;

  /**
   * 访问状态 0-成功, 1-失败
   */
  @ApiModelProperty("访问状态 0-成功, 1-失败")
  private Integer status;

  /**
   * 访问失败原因
   */
  @ApiModelProperty("备注")
  private String remark;

  /**
   * 生成时间
   */
  @ApiModelProperty("生成时间")
  private Date createTime;

  public AddSystemOperationLogDto() {
  }

  public AddSystemOperationLogDto(String userId, String userName, String userOrganizationName, String resourceType,
      String resourceId, String resourceName, String action, Integer status, String remark) {
    this.userId = userId;
    this.userName = userName;
    this.userOrganizationName = userOrganizationName;
    this.resourceType = resourceType;
    this.resourceId = resourceId;
    this.resourceName = resourceName;
    this.action = action;
    this.status = status;
    this.remark = remark;
    this.createTime = new Date();
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

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "AddSystemOperationLogDto{" +
        "userId='" + userId + '\'' +
        ", userName='" + userName + '\'' +
        ", userOrganizationName='" + userOrganizationName + '\'' +
        ", resourceType='" + resourceType + '\'' +
        ", resourceId='" + resourceId + '\'' +
        ", resourceName='" + resourceName + '\'' +
        ", action='" + action + '\'' +
        ", status=" + status +
        ", remark='" + remark + '\'' +
        ", createTime=" + createTime +
        '}';
  }
}
