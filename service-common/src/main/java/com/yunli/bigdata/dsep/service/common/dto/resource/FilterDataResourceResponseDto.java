package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.dto.tag.GetDataTagDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * FilterDataResourceResponseDto
 * @author wei
 */
@ApiModel(description = "查询数据表参数对象列表")
public class FilterDataResourceResponseDto implements Serializable {
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

  @ApiModelProperty("资源责任组织名称")
  private String responsibleOrganizationName;

  @ApiModelProperty("资源责任人ID")
  private String responsibleId;

  @ApiModelProperty("资源责任人名称")
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

  /**
   * 资源表关联的目录ID的列表
   **/
  @ApiModelProperty("资源表关联的目录ID的列表")
  private List<GetDataTagDto> tagIds;

  @ApiModelProperty("资源是否有关联目录")
  private Boolean inTags;

  @ApiModelProperty("数据量")
  private Long count;

  public FilterDataResourceResponseDto() {
  }

  public FilterDataResourceResponseDto(Long id, String nameEn, String nameCn, Integer status,
      String responsibleOrganizationId, String responsibleOrganizationName, String responsibleId,
      String responsibleName, Integer dataImportApprovalType,
      Integer sharingType, String sharingCondition, Boolean openToSociety, String openCondition,
      Boolean interactiveQuery, String description, Date publishedTime, Date createTime, Date updateTime,
      List<FilterResourceColumnResponseDto> resourceColumns, List<GetDataTagDto> tagIds, Long count, Boolean inTags) {
    this.id = id;
    this.nameEn = nameEn;
    this.nameCn = nameCn;
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
    this.publishedTime = publishedTime;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.resourceColumns = resourceColumns;
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

  /**
   * 资源表名称（英文）
   * @return nameEn
   **/
  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }


  /**
   * 资源表名称（中文）
   * @return nameCn
   **/
  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
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
   * 数据导入审批类型（0-不需审批，1-数据质量异常时审批，2-必须审批）
   * @return dataImportApprovalType
   **/
  public Integer getDataImportApprovalType() {
    return dataImportApprovalType;
  }

  public void setDataImportApprovalType(Integer dataImportApprovalType) {
    this.dataImportApprovalType = dataImportApprovalType;
  }

  /**
   * 是否需要交互式查询
   * @return interactiveQuery
   **/
  public Boolean getInteractiveQuery() {
    return interactiveQuery;
  }

  public void setInteractiveQuery(Boolean interactiveQuery) {
    this.interactiveQuery = interactiveQuery;
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
   * 数据表表Column信息列表
   * @return resourceColumns
   **/
  public List<FilterResourceColumnResponseDto> getResourceColumns() {
    return resourceColumns;
  }

  public void setResourceColumns(List<FilterResourceColumnResponseDto> resourceColumns) {
    this.resourceColumns = resourceColumns;
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
    // return this.tagIds != null && this.tagIds.size() > 0;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public String getSharingCondition() {
    return sharingCondition;
  }

  public void setSharingCondition(String sharingCondition) {
    this.sharingCondition = sharingCondition;
  }
}
