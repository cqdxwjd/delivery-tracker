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
 * @Description: 数据标签实体类
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/14 13:42
 */
@Entity
@Table(name = "data_tag")
@EntityListeners(AuditingEntityListener.class)
public class DataTag implements Serializable {

  // 标签ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 父标签
  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "parentId")
  private DataTag parent;

  // 标签名称
  @Column
  private String name;

  // 标签描述
  @Column
  private String description;

  // 标签发布状态，默认0 (0-未发布, 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布)
  @Column
  private Integer status;

  // 创建时间
  @CreatedDate
  @Column
  private Date createTime;

  @Column
  private Date publishedTime;

  // 更新时间
  @LastModifiedDate
  @Column
  private Date updateTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tree_id", referencedColumnName = "id")
  private DataTagTree tree;

  @JsonIgnore
  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "tags")
  private Set<DataResource> resources = new HashSet<>();

  @JsonIgnore
  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "documentCatalogs")
  private Set<DocumentResource> documentResources = new HashSet<>();

  @JsonIgnore
  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "tags")
  private Set<DataTopic> topics = new HashSet<>();

  public DataTag() {
  }

  public DataTag(String name, String description, Integer status) {
    this.name = name;
    this.description = description;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DataTag getParent() {
    return parent;
  }

  public void setParent(DataTag parent) {
    this.parent = parent;
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getPublishedTime() {
    return publishedTime;
  }

  public void setPublishedTime(Date publishedTime) {
    this.publishedTime = publishedTime;
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

  public DataTagTree getTree() {
    return tree;
  }

  public void setTree(DataTagTree tree) {
    if (null != this.tree) {
      this.tree.getTags().remove(this);
    }
    if (null != tree) {
      tree.getTags().add(this);
    }
    this.tree = tree;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Set<DataResource> getResources() {
    return resources;
  }

  public void setResources(Set<DataResource> resources) {
    if (null != this.resources) {
      for (DataResource resource : this.resources) {
        resource.getTags().remove(this);
      }
    }
    if (null != resources) {
      for (DataResource resource : resources) {
        resource.getTags().add(this);
      }
    }
    this.resources = resources;
  }

  public Set<DocumentResource> getDocumentResources() {
    return documentResources;
  }

  public void setDocumentResources(Set<DocumentResource> documentResources) {
    if (null != this.documentResources) {
      for (DocumentResource resource : this.documentResources) {
        resource.getDocumentCatalogs().remove(this);
      }
    }
    if (null != documentResources) {
      for (DocumentResource resource : documentResources) {
        resource.getDocumentCatalogs().add(this);
      }
    }
    this.documentResources = documentResources;
  }

  public Set<DataTopic> getTopics() {
    return topics;
  }

  public void setTopics(Set<DataTopic> topics) {
    if (null != this.topics) {
      for (DataTopic topic : this.topics) {
        topic.getTags().remove(this);
      }
    }
    if (null != topics) {
      for (DataTopic topic :topics) {
        topic.getTags().add(this);
      }
    }
    this.topics = topics;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataTag dataTag = (DataTag) o;
    return id.equals(dataTag.id) &&
        name.equals(dataTag.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
