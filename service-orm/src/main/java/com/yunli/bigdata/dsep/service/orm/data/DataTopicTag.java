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
@Table(name = "data_topic_tag")
@EntityListeners(AuditingEntityListener.class)
public class DataTopicTag implements Serializable {

  // 标签ID
  @Id
  @Column(name = "topic_id")
  private Long topicId;

  @Id
  @Column(name = "tag_id")
  private Long tagId;


  public DataTopicTag() {
  }

  public Long getTopicId() {
    return topicId;
  }

  public void setTopicId(Long topicId) {
    this.topicId = topicId;
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
    DataTopicTag that = (DataTopicTag) o;
    return Objects.equals(topicId, that.topicId) &&
        Objects.equals(tagId, that.tagId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topicId, tagId);
  }
}
