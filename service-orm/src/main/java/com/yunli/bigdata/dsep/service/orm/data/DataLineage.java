package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 血缘表(data_lineages)
 *
 * @author zhangws
 */
@Entity
@Table(name = "data_lineages")
@EntityListeners(AuditingEntityListener.class)
public class DataLineage implements Serializable {

  /**
   * id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 资源ID
   */
  @Column(name = "resource_id")
  private Long resourceId;

  /**
   * 资源表名称（英文）
   */
  @Column(name = "resource_name_en")
  private String resourceNameEn;

//  /**
//   * 资源表名称（中文）
//   */
//  @Column(name = "resource_name_cn")
//  private String resourceNameCn;
//
//  /**
//   * 责任组织
//   */
//  @Column(name = "responsible_organization")
//  private String responsibleOrganization;

  /**
   * 所属系统
   */
  @Column(name = "belong_system")
  private String belongSystem;

  /**
   * 所属专题
   */
  @Column(name = "belong_topic")
  private String belongTopic;

  /**
   * 应用场景
   */
  @Column(name = "application_scene")
  private String applicationScene;

  /**
   * 所属数仓层级
   */
  @Column(name = "level_id")
  private Integer levelId;

  /**
   * 状态（0:主,9:从）
   */
  @Column(name = "type")
  private Integer type;

  /**
   * 关系图坐标：X
   */
  @Column(name = "x")
  private Double x;

  /**
   * 关系图坐标：Y
   */
  @Column(name = "y")
  private Double y;

  /**
   * 创建者
   */
  @Column(name = "create_user")
  private String createUser;

  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  /**
   * 更新者
   */
  @Column(name = "update_user")
  private String updateUser;

  /**
   * 更新时间
   */
  @LastModifiedDate
  @Column(name = "update_time")
  private Date updateTime;

  public DataLineage() {
  }

  public DataLineage(Long resourceId,
      String resourceNameEn,
//      String resourceNameCn,
//      String responsibleOrganization,
      Integer type,
      Double x,
      Double y,
      String createUser,
      String updateUser
  ) {
    this.resourceId = resourceId;
    this.resourceNameEn = resourceNameEn;
//    this.resourceNameCn = resourceNameCn;
//    this.responsibleOrganization = responsibleOrganization;
    this.type = type;
    this.x = x;
    this.y = y;
    this.createUser = createUser;
    this.updateUser = updateUser;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }

  public String getResourceNameEn() {
    return resourceNameEn;
  }

  public void setResourceNameEn(String resourceNameEn) {
    this.resourceNameEn = resourceNameEn;
  }

//  public String getResourceNameCn() {
//    return resourceNameCn;
//  }
//
//  public void setResourceNameCn(String resourceNameCn) {
//    this.resourceNameCn = resourceNameCn;
//  }
//
//  public String getResponsibleOrganization() {
//    return responsibleOrganization;
//  }
//
//  public void setResponsibleOrganization(String responsibleOrganization) {
//    this.responsibleOrganization = responsibleOrganization;
//  }

  public String getBelongSystem() {
    return belongSystem;
  }

  public void setBelongSystem(String belongSystem) {
    this.belongSystem = belongSystem;
  }

  public String getBelongTopic() {
    return belongTopic;
  }

  public void setBelongTopic(String belongTopic) {
    this.belongTopic = belongTopic;
  }

  public String getApplicationScene() {
    return applicationScene;
  }

  public void setApplicationScene(String applicationScene) {
    this.applicationScene = applicationScene;
  }

  public Integer getLevelId() {
    return levelId;
  }

  public void setLevelId(Integer levelId) {
    this.levelId = levelId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataLineage that = (DataLineage) o;
    return Objects.equals(resourceId, that.resourceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceId);
  }
}