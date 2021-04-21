package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Description: 数据表和标签实体类
 * @Author: fdw
 * @CreateDate: 2020/9/22 13:42
 */
@Entity
@Table(name = "resource_tag")
@EntityListeners(AuditingEntityListener.class)
public class ResourceTag implements Serializable {

  // 标签ID
  @Id
  @Column(name = "resource_id")
  private Long resourceId;

  @Id
  @Column(name = "tag_id")
  private Long tagId;


  public ResourceTag() {
  }



  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }

  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceTag that = (ResourceTag) o;
    return Objects.equals(resourceId, that.resourceId) &&
        Objects.equals(tagId, that.tagId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceId, tagId);
  }
}
