package com.yunli.bigdata.dsep.service.common.dto.authentication;

import io.swagger.annotations.ApiModelProperty;


/**
 * @author wei
 */
public class GetResponsible {
  @ApiModelProperty("资源提供方ID")
  private String responsibleOrganizationId = "";

  @ApiModelProperty("资源提供方名称")
  private String responsibleOrganizationName = "";

  @ApiModelProperty("责任人ID")
  private String responsibleId = "";

  @ApiModelProperty("责任人")
  private String responsibleName = "";

  public GetResponsible() {
  }

  public GetResponsible(String responsibleOrganizationId, String responsibleOrganizationName,
      String responsibleId, String responsibleName) {
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleOrganizationName = responsibleOrganizationName;
    this.responsibleId = responsibleId;
    this.responsibleName = responsibleName;
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
}
