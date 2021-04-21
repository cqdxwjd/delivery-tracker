package com.yunli.bigdata.dsep.service.orm.audit;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * 数据访问审计日志实体
 * @author wei
 */
@Entity
@Table(name = "access_audit_log")
@EntityListeners(AuditingEntityListener.class)
public class AccessAuditLog implements Serializable {
  /**
   * ID
   */
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
   * 调用方式（api、job、download）
   */
  private String type;

  /**
   * 资源类型(data、document)
   */
  @Column
  private String resourceType;

  /**
   * 资源ID
   */
  @Column
  private Long resourceId;

  /**
   * 资源表名称
   */
  @Column
  private String name;

  /**
   * 文件夹ID
   */
  @Column
  private String fileName;

  /**
   * 责任组织ID
   */
  @Column
  private String organizationResponsible;

  /**
   * 责任组织名称
   */
  @Column
  private String organizationResponsibleName;

  /**
   * 访问状态 0-成功, 1-失败
   */
  @Column
  private Integer status;

  /**
   * 访问结果数量
   */
  @Column
  private Long count;

  /**
   * 访问失败原因
   */
  @Column
  private String reason;

  /**
   * 创建时间
   */
  @CreatedDate
  @Column
  private Date createTime;

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

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String documentId) {
    this.fileName = documentId;
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

  public AccessAuditLog() {
  }

  public AccessAuditLog(String id, String userId, String userName, String userOrganizationName, String type,
      String resourceType, Long resourceId, String name, String fileName, String organizationResponsible,
      String organizationResponsibleName, Integer status, Long count, String reason, Date createTime) {
    this.id = id;
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
    this.createTime = createTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessAuditLog that = (AccessAuditLog) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
