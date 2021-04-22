package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 添加TOPIC参数对象
 * @author david
 */
@ApiModel(description = "添加TOPIC参数对象")
public class AddDataTopicRequestDto implements Serializable {

  @ApiModelProperty("实时数据信道名称")
  @NotNull(message = "实时数据信道中文名不能为空")
  private String topicName;

  @ApiModelProperty("实时数据信道编码")
  // @NotBlank(message = "实时数据信道英文名不能为空")
  @Size(max = 64, message = "实时数据信道英文名字符数不能超过64")
  private String topicCode;

  @ApiModelProperty("分区数量")
  @NotNull(message = "分区数量不能为空")
  private Integer partitions;

  @ApiModelProperty("服务地址")
  private String servers;

  @ApiModelProperty("消费者组")
  private String consumerGroup;

  @ApiModelProperty("资源提供方")
  @NotNull(message = "资源提供方不能为空")
  private String responsibleOrganizationId;

  @ApiModelProperty("责任人")
  @NotNull(message = "责任人不能为空")
  private String responsibleId;

  @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
  private Integer sharingType;

  @ApiModelProperty("共享条件")
  private String sharingCondition;

  @ApiModelProperty("是否向社会开放(默认false)")
  private Boolean openToSociety = false;

  @ApiModelProperty("开放条件")
  private String openCondition;

  @ApiModelProperty("资源描述")
  private String description;

  @ApiModelProperty("资源Column信息列表")
  @NotNull(message = "实时数据信道的字段信息不能为空")
  private List<AddTopicColumnRequestDto> topicColumns;

  @ApiModelProperty("标签列表")
  private List<LabelInfo> labels;

  public AddDataTopicRequestDto() {
  }

  public AddDataTopicRequestDto(String topicName, String topicCode, String responsibleOrganizationId,
      String responsibleId, Integer sharingType, String sharingCondition,
      Boolean openToSociety, String openCondition,
      String description, List<AddTopicColumnRequestDto> topicColumns) {
    this.topicName = topicName;
    this.topicCode = topicCode;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleId = responsibleId;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.description = description;
    this.topicColumns = topicColumns;
  }


  public AddDataTopicRequestDto(String topicName, String topicCode, String servers, String consumerGroup,
      String responsibleOrganizationId,
      String responsibleId, Integer sharingType, String sharingCondition,
      Boolean openToSociety, String openCondition,
      String description, List<AddTopicColumnRequestDto> topicColumns) {
    this.topicName = topicName;
    this.topicCode = topicCode;
    this.servers = servers;
    this.consumerGroup = consumerGroup;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleId = responsibleId;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.description = description;
    this.topicColumns = topicColumns;
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
   * 资源描述
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

  public List<AddTopicColumnRequestDto> getTopicColumns() {
    return topicColumns;
  }

  public void setTopicColumns(
      List<AddTopicColumnRequestDto> topicColumns) {
    this.topicColumns = topicColumns;
  }

  public List<LabelInfo> getLabels() {
    return labels;
  }

  public void setLabels(List<LabelInfo> labels) {
    this.labels = labels;
  }

  public Integer getPartitions() {
    return partitions;
  }

  public void setPartitions(Integer partitions) {
    this.partitions = partitions;
  }

  
  public String getServers() {
    return servers;
  }

  public void setServers( String servers) {
    this.servers = servers;
  }

  
  public String getConsumerGroup() {
    return consumerGroup;
  }

  public void setConsumerGroup( String consumerGroup) {
    this.consumerGroup = consumerGroup;
  }
}
