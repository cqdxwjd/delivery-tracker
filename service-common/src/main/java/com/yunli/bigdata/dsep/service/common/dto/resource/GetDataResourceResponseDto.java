package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * GetDataResourceResponseDto
 * @author wei
 */

public class GetDataResourceResponseDto implements Serializable {
  /**
   * 数据表表ID
   **/
  @ApiModelProperty("数据表表ID")
  private Long id;

  @ApiModelProperty("资源表名称（中文）")
  private String nameCn;

  @ApiModelProperty("资源表名称（英文）")
  private String nameEn;

  /**
   * 数据表状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）
   **/
  @ApiModelProperty("数据表状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）")
  private Integer status;

  @ApiModelProperty("资源责任组织ID")
  private String responsibleOrganizationId;

  @ApiModelProperty("资源责任组织")
  private String responsibleOrganizationName;

  @ApiModelProperty("资源责任人ID")
  private String responsibleId;

  @ApiModelProperty("资源责任人")
  private String responsibleName;

  @ApiModelProperty("数据导入审批类型（0-不需审批，1-数据质量异常时审批，2-必须审批）")
  private Integer dataImportApprovalType;

  @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
  private Integer sharingType;

  @ApiModelProperty("共享条件")
  private String sharingCondition;

  @ApiModelProperty("是否向社会开放")
  private Boolean openToSociety;

  @ApiModelProperty("开放条件")
  private String openCondition;

  @ApiModelProperty("是否需要交互式查询 ")
  private Boolean interactiveQuery;

  @ApiModelProperty("资源描述")
  private String description;

  @ApiModelProperty("数据量")
  private Long count;

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
  private List<FilterResourceColumnResponseDto> resourceColumns;

  @ApiModelProperty("数据表扩展属性")
  private List<GetExtendProperty> extendProperties;

  /**
   * 资源表关联的目录ID的列表
   **/
  @ApiModelProperty("资源表关联的目录ID的列表")
  private List<Long> tagIds;

  /**
   * 资源表关联的目录ID的列表
   **/
  @ApiModelProperty("资源表关联的目录名称列表")
  private List<String> tagNames;

  public GetDataResourceResponseDto() {
  }

  public GetDataResourceResponseDto(Long id, String nameCn, String nameEn, Integer status,
      String responsibleOrganizationId, String responsibleOrganizationName, String responsibleId,
      String responsibleName, Integer dataImportApprovalType, Integer sharingType, String sharingCondition,
      Boolean openToSociety, String openCondition, Boolean interactiveQuery, String description, Long count,
      Date publishedTime, Date createTime, Date updateTime, List<FilterResourceColumnResponseDto> resourceColumns,
      List<GetExtendProperty> extendProperties, List<Long> tagIds, List<String> tagNames) {
    this.id = id;
    this.nameCn = nameCn;
    this.nameEn = nameEn;
    this.status = status;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleOrganizationName = responsibleOrganizationName;
    this.responsibleId = responsibleId;
    this.responsibleName = responsibleName;
    this.dataImportApprovalType = dataImportApprovalType;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.interactiveQuery = interactiveQuery;
    this.description = description;
    this.count = count;
    this.publishedTime = publishedTime;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.resourceColumns = resourceColumns;
    this.extendProperties = extendProperties;
    this.tagIds = tagIds;
    this.tagNames = tagNames;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }

  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
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

  public Integer getDataImportApprovalType() {
    return dataImportApprovalType;
  }

  public void setDataImportApprovalType(Integer dataImportApprovalType) {
    this.dataImportApprovalType = dataImportApprovalType;
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

  public Boolean getInteractiveQuery() {
    return interactiveQuery;
  }

  public void setInteractiveQuery(Boolean interactiveQuery) {
    this.interactiveQuery = interactiveQuery;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
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

  public List<FilterResourceColumnResponseDto> getResourceColumns() {
    return resourceColumns;
  }

  public void setResourceColumns(
      List<FilterResourceColumnResponseDto> resourceColumns) {
    this.resourceColumns = resourceColumns;
  }

  public List<GetExtendProperty> getExtendProperties() {
    return extendProperties;
  }

  public void setExtendProperties(
      List<GetExtendProperty> extendProperties) {
    this.extendProperties = extendProperties;
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

  @Override
  public String toString() {
    return "GetDataResourceResponseDto{" +
        "id=" + id +
        ", nameCn='" + nameCn + '\'' +
        ", nameEn='" + nameEn + '\'' +
        ", status=" + status +
        ", responsibleOrganizationId='" + responsibleOrganizationId + '\'' +
        ", responsibleOrganizationName='" + responsibleOrganizationName + '\'' +
        ", responsibleId='" + responsibleId + '\'' +
        ", responsibleName='" + responsibleName + '\'' +
        ", dataImportApprovalType=" + dataImportApprovalType +
        ", sharingType=" + sharingType +
        ", sharingCondition='" + sharingCondition + '\'' +
        ", openToSociety=" + openToSociety +
        ", openCondition='" + openCondition + '\'' +
        ", interactiveQuery=" + interactiveQuery +
        ", description='" + description + '\'' +
        ", count=" + count +
        ", publishedTime=" + publishedTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", resourceColumns=" + resourceColumns +
        ", extendProperties=" + extendProperties +
        ", tagIds=" + tagIds +
        ", tagNames=" + tagNames +
        '}';
  }
}
