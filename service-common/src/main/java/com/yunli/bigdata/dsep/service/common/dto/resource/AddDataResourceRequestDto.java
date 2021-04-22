package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 添加数据表参数对象
 * @author wei
 */
@ApiModel(description = "添加数据表参数对象")
public class AddDataResourceRequestDto implements Serializable {

  @ApiModelProperty("资源中文名")
  @NotNull(message = "资源中文名不能为空")
  private String nameCn;

  @ApiModelProperty("资源英文名")
  @NotBlank(message = "数据表英文名不能为空")
  @Size(max = 64, message = "数据表英文名字符数不能超过64")
  private String nameEn;

  @ApiModelProperty("资源提供方")
  @NotNull(message = "资源提供方不能为空")
  private String responsibleOrganizationId;

  @ApiModelProperty("责任人")
  @NotNull(message = "责任人不能为空")
  private String responsibleId;

  @ApiModelProperty("数据导入审批类型（0-不需审批，1-数据质量异常时审批，2-必须审批）")
  @NotNull(message = "数据导入审批类型不能为空")
  private Integer dataImportApprovalType;

  @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
  private Integer sharingType;

  @ApiModelProperty("共享条件")
  private String sharingCondition;

  @ApiModelProperty("是否向社会开放(默认false)")
  private Boolean openToSociety = false;

  @ApiModelProperty("开放条件")
  private String openCondition;

  @ApiModelProperty("是否需要交互式查询(默认false)")
  private Boolean interactiveQuery = false;

  @ApiModelProperty("资源描述")
  private String description;

  @ApiModelProperty("资源Column信息列表")
  @NotNull(message = "资源列信息不能为空")
  private List<AddResourceColumnRequestDto> resourceColumns;

  @ApiModelProperty("资源扩展属性列表")
  private List<ExtendProperty> extendProperties;

  public AddDataResourceRequestDto() {
  }

  public AddDataResourceRequestDto(String nameCn, String nameEn, String responsibleOrganizationId,
      String responsibleId, Integer dataImportApprovalType, Integer sharingType, String sharingCondition,
      Boolean openToSociety, String openCondition, Boolean interactiveQuery,
      String description, List<AddResourceColumnRequestDto> resourceColumns,
      List<ExtendProperty> extendProperties) {
    this.nameCn = nameCn;
    this.nameEn = nameEn;
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
   * 资源责任组织ID
   * @return responsibleOrganizationId
   **/
  public String getResponsibleOrganizationId() {
    return responsibleOrganizationId;
  }

  public void setResponsibleOrganizationId(String responsibleOrganizationId) {
    this.responsibleOrganizationId = responsibleOrganizationId;
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
   * 资源描述
   * @return description
   **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  /**
   * 资源Column信息列表
   * @return resourceColumns
   **/
  public List<AddResourceColumnRequestDto> getResourceColumns() {
    return resourceColumns;
  }

  public void setResourceColumns(List<AddResourceColumnRequestDto> resourceColumns) {
    this.resourceColumns = resourceColumns;
  }

  public List<ExtendProperty> getExtendProperties() {
    return extendProperties;
  }

  public void setExtendProperties(
      List<ExtendProperty> extendProperties) {
    this.extendProperties = extendProperties;
  }
}
