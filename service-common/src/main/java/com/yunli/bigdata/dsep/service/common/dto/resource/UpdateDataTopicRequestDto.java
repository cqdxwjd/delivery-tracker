package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * UpdateDataTopicRequestDto
 * @author david
 */

public class UpdateDataTopicRequestDto implements Serializable {

  /**
   * TOPIC名称（英文）
   **/
  @ApiModelProperty("实时数据信道编码")
  @NotBlank(message = "实时数据信道编码不能为空")
  @Size(max = 64, message = "实时数据信道编码字符数不能超过64")
  private String topicCode;

  /**
   * TOPIC名称（中文）
   **/
  @ApiModelProperty("实时数据信道名称（中文）")
  private String topicName;

  @ApiModelProperty("服务地址")
  private String servers;

  @ApiModelProperty("消费者组")
  private String consumerGroup;

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

  @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
  private Integer sharingType;

  @ApiModelProperty("共享条件")
  private String sharingCondition;

  @ApiModelProperty("是否向社会开放")
  private Boolean openToSociety;

  @ApiModelProperty("开放条件")
  private String openCondition;

  /**
   * TOPIC表描述
   **/
  @ApiModelProperty("实时数据信道表描述")
  private String description;

  /**
   * TOPIC表Column信息列表
   **/
  @ApiModelProperty("实时数据信道表Column信息列表")
  private List<UpdateTopicColumnRequestDto> topicColumns;

  @ApiModelProperty("标签列表")
  private List<LabelInfo> labels;

  @ApiModelProperty("修改原因")
  private String reason;

  @ApiModelProperty(value = "如果有冲突是否删除实体TOPIC")
  private Boolean deleteTable = false;

  public UpdateDataTopicRequestDto() {
  }

  public UpdateDataTopicRequestDto(String topicCode, String topicName,String responsibleOrganizationId,
      String responsibleId, Integer sharingType, String sharingCondition,
      Boolean openToSociety, String openCondition,String description,List<LabelInfo> labels) {
    this.topicCode = topicCode;
    this.topicName = topicName;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleId = responsibleId;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.description = description;
    this.labels = labels;
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

  public String getSharingCondition() {
    return sharingCondition;
  }

  public void setSharingCondition(String sharingCondition) {
    this.sharingCondition = sharingCondition;
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

  public List<UpdateTopicColumnRequestDto> getTopicColumns() {
    return topicColumns;
  }

  public void setTopicColumns(
      List<UpdateTopicColumnRequestDto> topicColumns) {
    this.topicColumns = topicColumns;
  }

  public List<LabelInfo> getLabels() {
    return labels;
  }

  public void setLabels(List<LabelInfo> labels) {
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
}
