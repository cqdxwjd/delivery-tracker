package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.dto.tag.GetDataTagDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * FilterDataTopicResponseDto
 * @author david
 */
@ApiModel(description = "查询TOPIC对象列表")
public class FilterDataTopicResponseDto implements Serializable {
  /**
   * Topic ID
   **/
  @ApiModelProperty("实时数据信道编码")
  private Long id;

  @ApiModelProperty("实时数据信道名称")
  private String topicName;

  @ApiModelProperty("实时数据信道代码")
  private String topicCode;

  /**
   * 数据表状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）
   **/
  @ApiModelProperty("数据表状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）")
  private Integer status;

  @ApiModelProperty("资源责任组织ID")
  private String responsibleOrganizationId;

  @ApiModelProperty("资源责任组织名称")
  private String responsibleOrganizationName;

  @ApiModelProperty("资源责任人ID")
  private String responsibleId;

  @ApiModelProperty("资源责任人名称")
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

  @ApiModelProperty("数据表表Column信息列表")
  private List<FilterTopicColumnResponseDto> topicColumns;

  /**
   * 资源表关联的目录ID的列表
   **/
  @ApiModelProperty("资源表关联的目录ID的列表")
  private List<GetDataTagDto> tagIds;

  @ApiModelProperty("资源是否有关联目录")
  private Boolean inTags;

  @ApiModelProperty("资源是否有数据")
  private Boolean hasData;

  public FilterDataTopicResponseDto() {
  }

  public FilterDataTopicResponseDto(Long id, String topicCode, String topicName, Integer status,
      String responsibleOrganizationId, String responsibleOrganizationName, String responsibleId,
      String responsibleName,
      Integer sharingType, String sharingCondition, Boolean openToSociety, String openCondition,
       String description, Date publishedTime, Date createTime, Date updateTime,
      List<FilterTopicColumnResponseDto> topicColumns, List<GetDataTagDto> tagIds, Boolean inTags) {
    this.id = id;
    this.topicCode = topicCode;
    this.topicName = topicName;
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
    this.inTags = inTags;
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


  /**
   * 资源责任组织ID
   * @return responsibleOrganizationId
   **/
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

  public String getResponsibleName() {
    return responsibleName;
  }

  public void setResponsibleName(String responsibleName) {
    this.responsibleName = responsibleName;
  }

  /**
   * 资源责任人ID
   * @return responsibleId
   **/
  public String getResponsibleId() {
    return responsibleId;
  }

  public void setResponsibleId(String responsibleId) {
    this.responsibleId = responsibleId;
  }

  /**
   * 数据表表描述
   * @return description
   **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getSharingType() {
    return sharingType;
  }

  public void setSharingType(Integer sharingType) {
    this.sharingType = sharingType;
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

  public void setInTags(Boolean inTags) {
    this.inTags = inTags;
  }

  /**
   * 数据表表创建时间
   * @return createTime
   **/
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  /**
   * 资源表更新时间
   * @return updateTime
   **/
  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * 资源表关联的目录ID的列表
   * @return tagIds
   **/
  public List<GetDataTagDto> getTagIds() {
    return tagIds;
  }

  public void setTagIds(List<GetDataTagDto> tagIds) {
    this.tagIds = tagIds;
  }

  public Boolean getInTags() {
    return this.inTags;
  }

  public Boolean getHasData() {
    return hasData;
  }

  public void setHasData(Boolean hasData) {
    this.hasData = hasData;
  }

  public String getSharingCondition() {
    return sharingCondition;
  }

  public void setSharingCondition(String sharingCondition) {
    this.sharingCondition = sharingCondition;
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

  public List<FilterTopicColumnResponseDto> getTopicColumns() {
    return topicColumns;
  }

  public void setTopicColumns(
      List<FilterTopicColumnResponseDto> topicColumns) {
    this.topicColumns = topicColumns;
  }
}
