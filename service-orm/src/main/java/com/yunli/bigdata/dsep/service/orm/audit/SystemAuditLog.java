package com.yunli.bigdata.dsep.service.orm.audit;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * @author wei
 */
@Entity
@Table(name = "system_audit_log")
@EntityListeners(AuditingEntityListener.class)
public class SystemAuditLog implements Serializable {

  @Id
  private String id;

  /**
   * 资源调用者ID
   */
  @Column
  private String userId;

  /**
   * 资源调用者名称
   */
  @Column
  private String userName;

  /**
   * 资源调用者组织名称
   */
  @Column
  private String userOrganizationName;

  /**
   * 资源类型(data、datatag、organization、group、role、user)
   */
  @Column
  private String resourceType;

  /**
   * 资源ID
   */
  @Column
  private String resourceId;

  /**
   * 资源ID
   */
  @Column
  private String resourceName;

  /**
   * 操作
   */
  @Column
  private String action;

  /**
   * 访问状态 0-成功, 1-失败
   */
  @Column
  private Integer status;

  /**
   * 备注
   */
  @Column
  private String remark;

  /**
   * 创建时间
   */
  @CreatedDate
  @Column
  private Date createTime;

  public SystemAuditLog() {
  }

  public SystemAuditLog(String id, String userId, String userName, String userOrganizationName,
      String resourceType, String resourceId, String resourceName, String action, Integer status,
      String remark, Date createTime) {
    this.id = id;
    this.userId = userId;
    this.userName = userName;
    this.userOrganizationName = userOrganizationName;
    this.resourceType = resourceType;
    this.resourceId = resourceId;
    this.resourceName = resourceName;
    this.action = action;
    this.status = status;
    this.remark = remark;
    this.createTime = createTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemAuditLog that = (SystemAuditLog) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "SystemAuditLog{" +
        "id='" + id + '\'' +
        ", userId='" + userId + '\'' +
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
