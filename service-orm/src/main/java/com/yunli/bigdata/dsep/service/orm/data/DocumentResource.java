package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;

/**
 * @author zhangws
 */
@Entity
@Table(name = "document_resources")
@EntityListeners(AuditingEntityListener.class)
public class DocumentResource {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /**
   * 文档名称
   */
  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "status")
  private Integer status;

  @Column(name = "sharing_type")
  private Integer sharingType;

  @Column(name = "sharing_condition")
  private String sharingCondition;

  @Column(name = "published_time")
  private Date publishedTime;

  @Column(name = "document_id")
  private Long documentId;

  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  @LastModifiedDate
  @Column(name = "update_time")
  private Date updateTime;

  @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinTable(name = "document_catalog",
      joinColumns = @JoinColumn(name = "document_id"),
      inverseJoinColumns = @JoinColumn(name = "catalog_id"))
  private Set<DataTag> documentCatalogs = new HashSet<>();

  @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinTable(name = "document_label_relation",
      joinColumns = @JoinColumn(name = "document_id"),
      inverseJoinColumns = @JoinColumn(name = "label_id"))
  private List<DataResourceExtendEnums> labels = new ArrayList<>();

  public DocumentResource() {
  }

  public DocumentResource(String name, String description, Integer status, Integer sharingType,
      String sharingCondition, Long documentId) {
    this.name = name;
    this.description = description;
    this.status = status;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.documentId = documentId;
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getSharingType() {
    return sharingType;
  }

  public void setSharingType(Integer sharingType) {
    this.sharingType = sharingType;
  }

  public String getSharingCondition() {
    return sharingCondition;
  }

  public void setSharingCondition(String sharingCondition) {
    this.sharingCondition = sharingCondition;
  }

  public Date getPublishedTime() {
    return publishedTime;
  }

  public void setPublishedTime(Date publishedTime) {
    this.publishedTime = publishedTime;
  }

  public Long getDocumentId() {
    return documentId;
  }

  public void setDocumentId(Long documentId) {
    this.documentId = documentId;
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

  public Set<DataTag> getDocumentCatalogs() {
    return documentCatalogs;
  }

  public void setDocumentCatalogs(Set<DataTag> documentCatalogs) {
    this.documentCatalogs = documentCatalogs;
  }

  public List<DataResourceExtendEnums> getLabels() {
    return labels;
  }

  public void setLabels(List<DataResourceExtendEnums> labels) {
    this.labels = labels;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentResource that = (DocumentResource) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
