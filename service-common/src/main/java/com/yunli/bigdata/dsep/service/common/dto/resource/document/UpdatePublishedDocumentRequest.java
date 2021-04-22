package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import com.yunli.bigdata.dsep.service.common.dto.resource.LabelInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhangws
 */
@ApiModel(description = "变更发布的文档")
public class UpdatePublishedDocumentRequest implements Serializable {

  @ApiModelProperty("文档名")
  @NotBlank(message = "文件夹名不能为空")
  @Size(max = 30, message = "文件夹名字符数不能超过30")
  private String name;

  @ApiModelProperty("文档提供方")
  @NotBlank(message = "文件夹提供方不能为空")
  private String responsibleOrganizationId;

  @ApiModelProperty("责任人")
  @NotBlank(message = "责任人不能为空")
  private String responsibleId;

  @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
  private Integer sharingType;

  @ApiModelProperty("使用要求")
  private String sharingCondition;

  @ApiModelProperty("摘要")
  private String description;

  @ApiModelProperty("标签列表")
  private List<LabelInfo> labels;

  @ApiModelProperty("原因")
  private String reason;

  @ApiModelProperty("允许同名(默认false)")
  private Boolean allowSameName = false;

  public UpdatePublishedDocumentRequest() {
  }

  public UpdatePublishedDocumentRequest(String name, String responsibleOrganizationId, String responsibleId,
      Integer sharingType, String sharingCondition, String description, List<LabelInfo> labels, String reason,
      Boolean allowSameName) {
    this.name = name;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleId = responsibleId;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.description = description;
    this.labels = labels;
    this.reason = reason;
    this.allowSameName = allowSameName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public List<LabelInfo> getLabels() {
    return labels;
  }

  public void setLabels(List<LabelInfo> labels) {
    this.labels = labels;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Boolean getAllowSameName() {
    return allowSameName;
  }

  public void setAllowSameName(Boolean allowSameName) {
    this.allowSameName = allowSameName;
  }
}
