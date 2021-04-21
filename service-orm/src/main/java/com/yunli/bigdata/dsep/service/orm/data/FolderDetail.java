package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhangws
 */
@Entity
@Table(name = "document_detail")
@EntityListeners(AuditingEntityListener.class)
public class FolderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column
  private Long folderId;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "description")
  private String description;

  @Column(name = "store_document_id")
  private Date storeDocumentId;

  @Column(name = "store_file_id")
  private Date storeFileId;

  @Column(name = "size")
  private Date size;

  @Column(name = "status")
  private Integer status;

  @Column(name = "published_time")
  private Date publishedTime;

  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  @LastModifiedDate
  @Column(name = "update_time")
  private Date updateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFolderId() {
    return folderId;
  }

  public void setFolderId(Long folderId) {
    this.folderId = folderId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStoreDocumentId() {
    return storeDocumentId;
  }

  public void setStoreDocumentId(Date storeDocumentId) {
    this.storeDocumentId = storeDocumentId;
  }

  public Date getStoreFileId() {
    return storeFileId;
  }

  public void setStoreFileId(Date storeFileId) {
    this.storeFileId = storeFileId;
  }

  public Date getSize() {
    return size;
  }

  public void setSize(Date size) {
    this.size = size;
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
    FolderDetail that = (FolderDetail) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
