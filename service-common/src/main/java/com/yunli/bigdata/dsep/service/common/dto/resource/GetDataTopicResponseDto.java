package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.dto.resource.label.LabelCatalog;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetDataTopicResponseDto
 * @author david
 */

public class GetDataTopicResponseDto implements Serializable {
  /**
   * TOPIC表ID
   **/
  @ApiModelProperty("实时数据信道表ID")
  private Long id;

  @ApiModelProperty("实时数据信道名称")
  private String topicName;

  @ApiModelProperty("实时数据信道编码")
  private String topicCode;


  @ApiModelProperty("服务地址")
  private String servers;


  @ApiModelProperty("消费者组")
  private String consumerGroup;


  @ApiModelProperty("分区个数")
  private Integer partitions;

  /**
   * TOPIC状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）
   **/
  @ApiModelProperty("实时数据信道状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）")
  private Integer status;

  @ApiModelProperty("资源责任组织ID")
  private String responsibleOrganizationId;

  @ApiModelProperty("资源责任组织")
  private String responsibleOrganizationName;

  @ApiModelProperty("资源责任人ID")
  private String responsibleId;

  @ApiModelProperty("资源责任人")
  private String responsibleName;

  @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
  private Integer sharingType;

  @ApiModelProperty("共享条件")
  private String sharingCondition;

  @ApiModelProperty("是否向社会开放")
  private Boolean openToSociety;

  @ApiModelProperty("开放条件")
  private String openCondition;

  @ApiModelProperty("资源描述")
  private String description;

  @ApiModelProperty("发布时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date publishedTime;

  @ApiModelProperty("创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @ApiModelProperty("更新时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  @ApiModelProperty("实时数据信道表Column信息列表")
  private List<FilterTopicColumnResponseDto> topicColumns;

  /**
   * TOPIC关联的目录ID的列表
   **/
  @ApiModelProperty("实时数据信道关联的目录ID的列表")
  private List<Long> tagIds;

  /**
   * TOPIC关联的目录ID的列表
   **/
  @ApiModelProperty("实时数据信道关联的目录名称列表")
  private List<String> tagNames;


  @ApiModelProperty("标签属性")
  private List<LabelCatalog> labels;

  public GetDataTopicResponseDto() {
  }

  public GetDataTopicResponseDto(Long id, String topicName, String topicCode,Integer partitions, Integer status,
      String responsibleOrganizationId, String responsibleOrganizationName, String responsibleId,
      String responsibleName,
      Integer sharingType, String sharingCondition, Boolean openToSociety, String openCondition,
      String description, Date publishedTime, Date createTime, Date updateTime,
      List<FilterTopicColumnResponseDto> topicColumns,
      List<Long> tagIds,
      List<String> tagNames) {
    this.id = id;
    this.topicName = topicName;
    this.topicCode = topicCode;
    this.partitions = partitions;
    this.status = status;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleOrganizationName = responsibleOrganizationName;
    this.responsibleId = responsibleId;
    this.responsibleName = responsibleName;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.description = description;
    this.publishedTime = publishedTime;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.topicColumns = topicColumns;
    this.tagIds = tagIds;
    this.tagNames = tagNames;
  }

  public GetDataTopicResponseDto(Long id, String topicName, String topicCode, String servers,
      String consumerGroup, Integer partitions, Integer status,
      String responsibleOrganizationId, String responsibleOrganizationName, String responsibleId,
      String responsibleName,
      Integer sharingType, String sharingCondition, Boolean openToSociety, String openCondition,
      String description, Date publishedTime, Date createTime, Date updateTime,
      List<FilterTopicColumnResponseDto> topicColumns,
      List<Long> tagIds,
      List<String> tagNames) {
    this.id = id;
    this.topicName = topicName;
    this.topicCode = topicCode;
    this.servers = servers;
    this.consumerGroup = consumerGroup;
    this.partitions = partitions;
    this.status = status;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleOrganizationName = responsibleOrganizationName;
    this.responsibleId = responsibleId;
    this.responsibleName = responsibleName;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.description = description;
    this.publishedTime = publishedTime;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.topicColumns = topicColumns;
    this.tagIds = tagIds;
    this.tagNames = tagNames;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getResponsibleOrganizationId() {
    return responsibleOrganizationId;
  }

  public void setResponsibleOrganizationId(String responsibleOrganizationId) {
    this.responsibleOrganizationId = responsibleOrganizationId;
  }

  public String getResponsibleOrganizationName() {
    return responsibleOrganizationName;
  }

  public void setResponsibleOrganizationName(String responsibleOrganizationName) {
    this.responsibleOrganizationName = responsibleOrganizationName;
  }

  public String getResponsibleId() {
    return responsibleId;
  }

  public void setResponsibleId(String responsibleId) {
    this.responsibleId = responsibleId;
  }

  public String getResponsibleName() {
    return responsibleName;
  }

  public void setResponsibleName(String responsibleName) {
    this.responsibleName = responsibleName;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public List<Long> getTagIds() {
    return tagIds;
  }

  public void setTagIds(List<Long> tagIds) {
    this.tagIds = tagIds;
  }

  public List<String> getTagNames() {
    return tagNames;
  }

  public void setTagNames(List<String> tagNames) {
    this.tagNames = tagNames;
  }

  public String getTopicName() {
    return topicName;
  }

  public void setTopicName(String topicName) {
    this.topicName = topicName;
  }

  public String getTopicCode() {
    return topicCode;
  }

  public void setTopicCode(String topicCode) {
    this.topicCode = topicCode;
  }

  public Integer getPartitions() {
    return partitions;
  }

  public void setPartitions(Integer partitions) {
    this.partitions = partitions;
  }

  public List<FilterTopicColumnResponseDto> getTopicColumns() {
    return topicColumns;
  }

  public void setTopicColumns(
      List<FilterTopicColumnResponseDto> topicColumns) {
    this.topicColumns = topicColumns;
  }

  public List<LabelCatalog> getLabels() {
    return labels;
  }

  public void setLabels(List<LabelCatalog> labels) {
    this.labels = labels;
  }

  public String getServers() {
    return servers;
  }

  public void setServers(String servers) {
    this.servers = servers;
  }

  public String getConsumerGroup() {
    return consumerGroup;
  }

  public void setConsumerGroup(String consumerGroup) {
    this.consumerGroup = consumerGroup;
  }

  @Override
  public String toString() {
    return "GetDataTopicResponseDto{" +
        "id=" + id +
        ", topicName='" + topicName + '\'' +
        ", topicCode='" + topicCode + '\'' +
        ", partitions=" + partitions +
        ", status=" + status +
        ", responsibleOrganizationId='" + responsibleOrganizationId + '\'' +
        ", responsibleOrganizationName='" + responsibleOrganizationName + '\'' +
        ", responsibleId='" + responsibleId + '\'' +
        ", responsibleName='" + responsibleName + '\'' +
        ", sharingType=" + sharingType +
        ", sharingCondition='" + sharingCondition + '\'' +
        ", openToSociety=" + openToSociety +
        ", openCondition='" + openCondition + '\'' +
        ", description='" + description + '\'' +
        ", publishedTime=" + publishedTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", topicColumns=" + topicColumns +
        ", tagIds=" + tagIds +
        ", tagNames=" + tagNames +
        ", labels=" + labels +
        '}';
  }
}
