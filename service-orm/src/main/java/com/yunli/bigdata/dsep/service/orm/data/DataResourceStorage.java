package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * 数据存储信息表(storages)
 *
 * @author wei
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "data_resource_storages")
public class DataResourceStorage implements Serializable {
  /**
   * 数据存储信息ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /**
   * 数据存储信息类型
   */
  @Column(name = "type")
  private String type;

  /**
   * 数据存储信息名称
   */
  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  /**
   * 数据存储信息连接信息
   */
  @Column(name = "connection")
  private String connection;

  @Column(name = "scope")
  private Integer scope;

  /**
   * 创建时间
   */
  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  /**
   * 更新时间
   */
  @LastModifiedDate
  @Column(name = "update_time")
  private Date updateTime;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.REFRESH}, mappedBy = "storages")
  private Set<DataResource> resources;

  public DataResourceStorage() {
  }

  public DataResourceStorage(String type, String name, String description, String connection,
      Integer scope) {
    this.type = type;
    this.name = name;
    this.description = description;
    this.connection = connection;
    this.scope = scope;
  }

  /**
   * 获取数据存储信息ID
   *
   * @return 数据存储信息ID
   */
  public Long getId() {
    return this.id;
  }

  /**
   * 设置数据存储信息ID
   *
   * @param id 数据存储信息ID
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取数据存储信息类型 0-ODPS,1-MySQL,2-Hive...
   *
   * @return 数据存储信息类型 0-MaxCompute
   */
  public String getType() {
    return this.type;
  }

  /**
   * 设置数据存储信息类型 0-ODPS,1-MySQL,2-Hive...
   *
   * @param type 数据存储信息类型 0-MaxCompute
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * 获取数据存储信息名称
   *
   * @return 数据存储信息名称
   */
  public String getName() {
    return this.name;
  }

  /**
   * 设置数据存储信息名称
   *
   * @param name 数据存储信息名称
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

  public Integer getScope() {
    return scope;
  }

  public void setScope(Integer scope) {
    this.scope = scope;
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

  public Set<DataResource> getResources() {
    return resources;
  }

  public void setResources(Set<DataResource> resources) {
    this.resources = resources;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataResourceStorage dataResourceStorage = (DataResourceStorage) o;
    return Objects.equals(id, dataResourceStorage.id) &&
        Objects.equals(name, dataResourceStorage.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
