package com.yunli.bigdata.dsep.service.orm.job;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 数据源
 *
 * @author zhangws
 */
@Entity
@Table(name = "data_source", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@EntityListeners(AuditingEntityListener.class)
public class DataSource implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 数据源名称
   */
  @Column
  private String name;

  /**
   * 数据源类型
   */
  @Column
  private String type;

  @Column
  private String description;

  /**
   * 连接信息
   */
  @Column
  private String connection;

  /**
   * 创建时间
   */
  @CreatedDate
  @Column
  private Date createTime;

  /**
   * 更新时间
   */
  @LastModifiedDate
  @Column
  private Date updateTime;

  public DataSource() {
  }

  public DataSource(String name, String type, String connection) {
    this.name = name;
    this.type = type;
    this.connection = connection;
  }

  public DataSource(String type, String name, String description,
      String connection) {
    this.type = type;
    this.name = name;
    this.description = description;
    this.connection = connection;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取数据源类型
   *
   * @return 数据源类型
   */
  public String getType() {
    return this.type;
  }

  /**
   * 设置数据源类型
   *
   * @param type 数据源类型
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * 获取数据源名称
   *
   * @return 数据源名称
   */
  public String getName() {
    return this.name;
  }

  /**
   * 设置数据源名称
   *
   * @param name 数据源名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取数据存储信息描述
   *
   * @return 数据存储信息描述
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * 设置数据存储信息描述
   *
   * @param description 数据存储信息描述
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 获取数据存储信息连接信息
   *
   * @return 数据存储信息连接信息
   */
  public String getConnection() {
    return this.connection;
  }

  /**
   * 设置数据存储信息连接信息
   *
   * @param connection 数据存储信息连接信息
   */
  public void setConnection(String connection) {
    this.connection = connection;
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
    DataSource dataResourceStorage = (DataSource) o;
    return Objects.equals(name, dataResourceStorage.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
