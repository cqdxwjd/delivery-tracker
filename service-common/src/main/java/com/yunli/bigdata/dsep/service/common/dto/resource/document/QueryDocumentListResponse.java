package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.dto.tag.GetDataTagDto;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhangws
 */
public class QueryDocumentListResponse implements Serializable {

  /**
   * 数据表表ID
   **/
  @ApiModelProperty("文档ID")
  private Long id;

  @ApiModelProperty("文档名称")
  private String name;

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

  /**
   * 资源表关联的目录ID的列表
   **/
  @ApiModelProperty("资源表关联的目录ID的列表")
  private List<GetDataTagDto> tagIds;

  @ApiModelProperty("资源是否有关联目录")
  private Boolean inTags;

  @ApiModelProperty("文件数")
  private Long count;

  public QueryDocumentListResponse() {
  }

  public QueryDocumentListResponse(Long id, String name, Integer status, String responsibleOrganizationId,
      String responsibleOrganizationName, String responsibleId, String responsibleName, Integer sharingType,
      String sharingCondition, String description, Date publishedTime, Date createTime, Date updateTime,
      List<GetDataTagDto> tagIds, Long count, Boolean inTags) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleOrganizationName = responsibleOrganizationName;
    this.responsibleId = responsibleId;
    this.responsibleName = responsibleName;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.description = description;
    this.publishedTime = publishedTime;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.tagIds = tagIds;
    this.count = count;
    this.inTags = inTags;
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

  public List<GetDataTagDto> getTagIds() {
    return tagIds;
  }

  public void setTagIds(List<GetDataTagDto> tagIds) {
    this.tagIds = tagIds;
  }

  public Boolean getInTags() {
    return this.inTags;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }
}
