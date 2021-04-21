package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 数据表表结构(data_resource_columns)
 *
 * @author wei
 */
@Entity
@Table(name = "data_resource_columns")
@EntityListeners(AuditingEntityListener.class)
public class DataResourceColumn implements Serializable {
  /** ID */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "resource_id")
  private DataResource resource;

  /** 字段名称 */
  @Column(name = "column_name")
  private String columnName;

  /** 字段类型 类型编号 */
  @Column(name = "column_type")
  private String columnType;

  /** 字段描述 */
  @Column(name = "column_description")
  private String columnDescription;

  /** 是否分区字段 */
  @Column(name = "partition_column")
  private boolean partitionColumn = false;

  /** 是否涉密 */
  @Column(name = "secret")
  private boolean secret = false;

  /** 创建时间 */
  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  /** 更新时间 */
  @LastModifiedDate
  @Column(name = "update_time")
  private Date updateTime;

  public DataResourceColumn() {
  }

  public DataResourceColumn(DataResource resource, String columnName, String columnType, String columnDescription,
      boolean partitionColumn, boolean secret) {
    this.resource = resource;
    this.columnName = columnName;
    this.columnType = columnType;
    this.columnDescription = columnDescription;
    this.partitionColumn = partitionColumn;
    this.secret = secret;
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

  public DataResource getResource() {
    return resource;
  }

  public void setResource(DataResource resource) {
    if (this.resource != null) {
      this.resource.getColumns().remove(this);
    }
    if (resource != null) {
      resource.getColumns().add(this);
    }
    this.resource = resource;
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
   * 获取是否区分字段
   *
   * @return 是否区分字段
   */
  public boolean isPartitionColumn() {
    return partitionColumn;
  }

  /**
   * 设置是否区分字段
   *
   * @param partitionColumn 是否区分字段
   */
  public void setPartitionColumn(boolean partitionColumn) {
    this.partitionColumn = partitionColumn;
  }

  public boolean isSecret() {
    return secret;
  }

  public void setSecret(boolean secret) {
    this.secret = secret;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataResourceColumn that = (DataResourceColumn) o;
    return Objects.equals(resource, that.resource) &&
        Objects.equals(columnName, that.columnName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource, columnName);
  }

  @Override
  public String toString() {
    return "DataResourceColumn{" +
        "id=" + id +
        ", resource=" + resource +
        ", columnName='" + columnName + '\'' +
        ", columnType='" + columnType + '\'' +
        ", columnDescription='" + columnDescription + '\'' +
        ", partitionColumn=" + partitionColumn +
        ", secret=" + secret +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        '}';
  }
}