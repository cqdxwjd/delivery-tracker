package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * TOPIC表结构(data_topic_columns)
 *
 * @author david
 */
@Entity
@Table(name = "data_topic_columns")
@EntityListeners(AuditingEntityListener.class)
public class DataTopicColumn implements Serializable {
  /** ID */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "topic_id")
  private DataTopic topic;

  /** 字段名称 */
  @Column(name = "column_name")
  private String columnName;

  /** 字段类型 类型编号 */
  @Column(name = "column_type")
  private String columnType;

  /** 字段描述 */
  @Column(name = "column_description")
  private String columnDescription;


  /** 字段描述 */
  @Column(name = "sort_id")
  private Integer sortId;

  /** 创建时间 */
  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  /** 更新时间 */
  @LastModifiedDate
  @Column(name = "update_time")
  private Date updateTime;

  public DataTopicColumn() {
  }

  public DataTopicColumn(DataTopic topic, String columnName, String columnType, String columnDescription,
      Integer sortId) {
    this.topic = topic;
    this.columnName = columnName;
    this.columnType = columnType;
    this.columnDescription = columnDescription;
    this.sortId = sortId;
  }

  /**
   * 获取ID
   *
   * @return ID
   */
  public Long getId() {
    return this.id;
  }

  /**
   * 设置ID
   *
   * @param id ID
   */
  public void setId(Long id) {
    this.id = id;
  }

  public DataTopic getResource() {
    return topic;
  }

  public void setResource(DataTopic topic) {
    if (this.topic != null) {
      this.topic.getColumns().remove(this);
    }
    if (topic != null) {
      topic.getColumns().add(this);
    }
    this.topic = topic;
  }

  /**
   * 获取字段名称
   *
   * @return 字段名称
   */
  public String getColumnName() {
    return this.columnName;
  }

  /**
   * 设置字段名称
   *
   * @param columnName 字段名称
   */
  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  /**
   * 获取字段类型 类型编号
   *
   * @return 字段类型 类型编号
   */
  public String getColumnType() {
    return this.columnType;
  }

  /**
   * 设置字段类型 类型编号
   *
   * @param columnType 字段类型 类型编号
   */
  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }

  /**
   * 获取字段描述
   *
   * @return 字段描述
   */
  public String getColumnDescription() {
    return this.columnDescription;
  }

  /**
   * 设置字段描述
   *
   * @param columnDescription 字段描述
   */
  public void setColumnDescription(String columnDescription) {
    this.columnDescription = columnDescription;
  }

  /**
   * 获取创建时间
   *
   * @return 创建时间
   */
  public Date getCreateTime() {
    return this.createTime;
  }

  /**
   * 设置创建时间
   *
   * @param createTime 创建时间
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 获取更新时间
   *
   * @return 更新时间
   */
  public Date getUpdateTime() {
    return this.updateTime;
  }

  /**
   * 设置更新时间
   *
   * @param updateTime 更新时间
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public DataTopic getTopic() {
    return topic;
  }

  public void setTopic(DataTopic topic) {
    this.topic = topic;
  }

  public Integer getSortId() {
    return sortId;
  }

  public void setSortId(Integer sortId) {
    this.sortId = sortId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataTopicColumn that = (DataTopicColumn) o;
    return Objects.equals(topic, that.topic) &&
        Objects.equals(columnName, that.columnName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topic, columnName);
  }

  @Override
  public String toString() {
    return "DataResourceColumn{" +
        "id=" + id +
        ", resource=" + topic +
        ", columnName='" + columnName + '\'' +
        ", columnType='" + columnType + '\'' +
        ", columnDescription='" + columnDescription + '\'' +
        ", sortId='" + sortId + '\'' +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        '}';
  }
}