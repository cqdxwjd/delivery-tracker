package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 血缘关系表(data_lineage_relations)
 *
 * @author zhangws
 */
@Entity
@Table(name = "data_lineage_relations")
@EntityListeners(AuditingEntityListener.class)
public class DataLineageRelation implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 当前节点ID
   */
  @Column(name = "current_id")
  private Long currentId;

  /**
   * 子节点
   */
  @Column(name = "child_id")
  private Long childId;

  /**
   * 创建者
   */
  @Column(name = "create_user")
  private String createUser;

  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  public DataLineageRelation() {
  }

  public DataLineageRelation(Long currentId,
      Long childId,
      String createUser
  ) {
    this.currentId = currentId;
    this.childId = childId;
    this.createUser = createUser;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCurrentId() {
    return currentId;
  }

  public void setCurrentId(Long currentId) {
    this.currentId = currentId;
  }

  public Long getChildId() {
    return childId;
  }

  public void setChildId(Long childId) {
    this.childId = childId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataLineageRelation that = (DataLineageRelation) o;
    return currentId.equals(that.getCurrentId()) && childId.equals(that.getChildId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentId, childId);
  }
}