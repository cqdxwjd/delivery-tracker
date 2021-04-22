package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateDataResourceRequestDto
 * @author wei
 */

public class UpdateDataResourceRequestDto implements Serializable {

  /**
   * 资源表名称（英文）
   **/
  @ApiModelProperty("资源表名称（英文）")
  @NotBlank(message = "数据表英文名不能为空")
  @Size(max = 64, message = "数据表英文名字符数不能超过64")
  private String nameEn;

  /**
   * 资源表名称（中文）
   **/
  @ApiModelProperty("资源表名称（中文）")
  private String nameCn;


  /**
   * 资源责任组织ID
   **/
  @ApiModelProperty("资源责任组织ID")
  private String responsibleOrganizationId;


  /**
   * 资源责任人ID
   **/
  @ApiModelProperty("资源责任人ID")
  private String responsibleId;

  /**
   * 数据导入审批类型（0-不需审批，1-数据质量异常时审批，2-必须审批）
   **/
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

  /**
   * 是否需要交互式查询
   **/
  @ApiModelProperty("是否需要交互式查询")
  private Boolean interactiveQuery;

  /**
   * 数据表表描述
   **/
  @ApiModelProperty("数据表表描述")
  private String description;

  /**
   * 数据表表Column信息列表
   **/
  @ApiModelProperty("数据表表Column信息列表")
  private List<UpdateResourceColumnRequestDto> resourceColumns;

  @ApiModelProperty("资源扩展属性列表")
  private List<ExtendProperty> extendProperties;

  @ApiModelProperty("修改原因")
  private String reason;

  @ApiModelProperty(value = "如果有冲突是否删除实体数据表")
  private Boolean deleteTable = false;

  public UpdateDataResourceRequestDto() {
  }

  public UpdateDataResourceRequestDto(String nameEn, String nameCn, String responsibleOrganizationId,
      String responsibleId, Integer dataImportApprovalType, Integer sharingType, String sharingCondition,
      Boolean openToSociety, String openCondition, Boolean interactiveQuery, String description,
      List<UpdateResourceColumnRequestDto> resourceColumns, List<ExtendProperty> extendProperties) {
    this.nameEn = nameEn;
    this.nameCn = nameCn;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleId = responsibleId;
    this.dataImportApprovalType = dataImportApprovalType;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.interactiveQuery = interactiveQuery;
    this.description = description;
    this.resourceColumns = resourceColumns;
    this.extendProperties = extendProperties;
  }

  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }


  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }

  public String getResponsibleOrganizationId() {
    return responsibleOrganizationId;
  }

  public void setResponsibleOrganizationId(String responsibleOrganizationId) {
    this.responsibleOrganizationId = responsibleOrganizationId;
  }

  public String getResponsibleId() {
    return responsibleId;
  }

  public void setResponsibleId(String responsibleId) {
    this.responsibleId = responsibleId;
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

  public List<UpdateResourceColumnRequestDto> getResourceColumns() {
    return resourceColumns;
  }

  public void setResourceColumns(List<UpdateResourceColumnRequestDto> resourceColumns) {
    this.resourceColumns = resourceColumns;
  }

  public String getSharingCondition() {
    return sharingCondition;
  }

  public void setSharingCondition(String sharingCondition) {
    this.sharingCondition = sharingCondition;
  }

  public List<ExtendProperty> getExtendProperties() {
    return extendProperties;
  }

  public void setExtendProperties(
      List<ExtendProperty> extendProperties) {
    this.extendProperties = extendProperties;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Boolean getDeleteTable() {
    return deleteTable;
  }

  public void setDeleteTable(Boolean deleteTable) {
    this.deleteTable = deleteTable;
  }
}
