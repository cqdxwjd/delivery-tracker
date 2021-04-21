package com.yunli.bigdata.dsep.service.orm.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description: 数据标签树实体类
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/13 11:48
 */
@Entity
@Table(name = "data_tag_tree", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@EntityListeners(AuditingEntityListener.class)
public class DataTagTree implements Serializable {

  // 标签树ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 标签树名称
  @Column
  private String name;

  // 标签树描述
  @Column
  private String description;

  // 创建时间
  @CreatedDate
  @Column
  private Date createTime;

  // 更新时间
  @LastModifiedDate
  @Column
  private Date updateTime;

  @JsonIgnore
  @OneToMany(mappedBy = "tree",
      cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  private Set<DataTag> tags = new HashSet<>();

  public DataTagTree() {
  }

  public DataTagTree(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Set<DataTag> getTags() {
    return tags;
  }

  public void setTags(Set<DataTag> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataTagTree that = (DataTagTree) o;
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
