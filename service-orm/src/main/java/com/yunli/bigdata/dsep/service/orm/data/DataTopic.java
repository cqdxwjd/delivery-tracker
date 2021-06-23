package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * 数据订阅主题表(data_topics)
 *
 * @author david
 */
@Entity
@Table(name = "data_topics")
@EntityListeners(AuditingEntityListener.class)
public class DataTopic implements Serializable {
  /** 资源id */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** TOPIC名称（英文） */
  @Column(name = "topic_code")
  private String topicCode;

  /** TOPIC名称（中文） */
  @Column(name = "topic_name")
  private String topicName;

  /** 消息中间件地址 */
  @Column(name = "servers")
  private String servers;

  @Column(name = "consumer_group")
  private String consumerGroup;

  /** 资源概要描述 */
  @Column(name = "description")
  private String description;

  @Column(name = "partitions")
  private Integer partitions;

  /** 资源状态（对应是否发布：0-未发布(初始状态), 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中 */
  @Column(name = "status")
  private Integer status;

  /** 共享类型（0-有条件共享，1-无条件共享，2-不予共享） */
  @Column(name = "sharing_type")
  private Integer sharingType = 0;

  /** 共享条件 */
  @Column(name = "sharing_condition")
  private String sharingCondition;

  /** 是否向社会开放(默认false) */
  @Column(name = "open_to_society")
  private Boolean openToSociety = false;

  /** 开放条件*/
  @Column(name = "open_condition")
  private String openCondition;

  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  /** 发布时间 */
  @Column(name = "published_time")
  private Date publishedTime;

  /** 更新时间 */
  @LastModifiedDate
  @Column(name = "update_time")
  private Date updateTime;

  /**
   * 资源目录
   */
  @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinTable(name = "data_topic_tag",
      joinColumns = @JoinColumn(name = "topic_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private Set<DataTag> tags = new HashSet<>();

  /**
   * 标签
   */
  @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinTable(name = "data_topic_label_relation",
      joinColumns = @JoinColumn(name = "topic_id"),
      inverseJoinColumns = @JoinColumn(name = "label_id"))
  private List<DataResourceExtendEnums> labels = new ArrayList<>();

  @OneToMany(mappedBy = "topic", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
  @OrderBy(value = "sortId ASC")
  private List<DataTopicColumn> columns = new ArrayList<>();

  public DataTopic() {
  }

  public DataTopic(String topicCode, String topicName,Integer partitions, String description, Integer status,
       Integer sharingType, String sharingCondition, Boolean openToSociety,
      String openCondition) {
    this.topicCode = topicCode;
    this.topicName = topicName;
    this.partitions = partitions;
    this.description = description;
    this.status = status;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
  }


  public DataTopic(String topicCode, String topicName,Integer partitions, String description, Integer status,
      Integer sharingType, String sharingCondition, Boolean openToSociety,
      String openCondition, String servers, String consumerGroup) {
    this.topicCode = topicCode;
    this.topicName = topicName;
    this.partitions = partitions;
    this.description = description;
    this.status = status;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.servers = servers;
    this.consumerGroup = consumerGroup;
  }

  /**
   * 获取资源id
   *
   * @return 资源id
   */
  public Long getId() {
    return this.id;
  }

  /**
   * 设置资源id
   *
   * @param id 资源id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取资源概要描述
   *
   * @return 资源概要描述
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * 设置资源概要描述
   *
   * @param description 资源概要描述
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 获取资源状态（对应是否发布：0-未发布(初始状态), 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布
   *
   * @return 资源状态（对应是否发布：0-未发布(初始状态)
   */
  public Integer getStatus() {
    return this.status;
  }

  /**
   * 设置资源状态（对应是否发布：0-未发布(初始状态), 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布
   *
   * @param status 资源状态（对应是否发布：0-未发布(初始状态)
   */
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

  public Boolean getOpenToSociety() {
    return openToSociety;
  }

  public void setOpenToSociety(Boolean openToSociety) {
    this.openToSociety = openToSociety;
  }

  public String getOpenCondition() {
    return openCondition;
  }

  public void setOpenCondition(String openCondition) {
    this.openCondition = openCondition;
  }

  public Date getPublishedTime() {
    return publishedTime;
  }

  public void setPublishedTime(Date publishedTime) {
    this.publishedTime = publishedTime;
  }

  public String getTopicCode() {
    return topicCode;
  }

  public void setTopicCode(String topicCode) {
    this.topicCode = topicCode;
  }

  public String getTopicName() {
    return topicName;
  }

  public void setTopicName(String topicName) {
    this.topicName = topicName;
  }

  public Integer getPartitions() {
    return partitions;
  }

  public void setPartitions(Integer partitions) {
    this.partitions = partitions;
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

  public String getServers() {
    return servers;
  }

  public void setServers(String servers) {
    this.servers = servers;
  }

  /**
   * 设置更新时间
   *
   * @param updateTime 更新时间
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Set<DataTag> getTags() {
    return tags;
  }

  public void setTags(Set<DataTag> tags) {
    if (this.tags != null) {
      for (DataTag tag : this.tags) {
        tag.getResources().remove(this);
      }
    }
    if (tags != null) {
      for (DataTag tag : tags) {
        // tag.getResources().add(this);
      }
    }
    this.tags = tags;
  }

  public List<DataTopicColumn> getColumns() {
    return columns;
  }

  public void setColumns(List<DataTopicColumn> columns) {
    this.columns = columns;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataTopic that = (DataTopic) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(topicCode, that.topicCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, topicCode);
  }


  public List<DataResourceExtendEnums> getLabels() {
    return labels;
  }

  public void setLabels(List<DataResourceExtendEnums> labels) {
    this.labels = labels;
  }

  public String getConsumerGroup() {
    return consumerGroup;
  }

  public void setConsumerGroup(String consumerGroup) {
    this.consumerGroup = consumerGroup;
  }
}