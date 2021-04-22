package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 查询数据表参数对象
 * @author wei
 */
@ApiModel(description = "查询发布后的数据表参数对象")
public class QueryPublishedResourceRequest implements Serializable {
  @ApiModelProperty("资源名称")
  private String name;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long tagId;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long treeId;

  @ApiModelProperty("资源提供方")
  private String responsibleOrganizationId;

  @ApiModelProperty("资源类型（数据表:data 文件夹:document 实时信道:topic）")
  private String type;

  /**
   * 查询此资源的用户对此资源的访问权限
   **/
  @ApiModelProperty("查询此资源的用户对此资源的访问权限（未申请:0 审批中:1 已授权:2）")
  private Integer subscribeStatus;

  @JsonIgnore
  @ApiModelProperty(value = "查询的数据表列表", hidden = true)
  private List<Long> dataResourceIds = null;

  @JsonIgnore
  @ApiModelProperty(value = "排除的数据表列表", hidden = true)
  private List<Long> excludedDataResourceIds = null;

  @JsonIgnore
  @ApiModelProperty(value = "查询的文件夹列表", hidden = true)
  private List<Long> documentIds = null;

  @JsonIgnore
  @ApiModelProperty(value = "排除的文件夹列表", hidden = true)
  private List<Long> excludedDocumentIds = null;


  @JsonIgnore
  @ApiModelProperty(value = "查询的实时数据信道列表", hidden = true)
  private List<Long> dataTopicIds = null;

  @JsonIgnore
  @ApiModelProperty(value = "排除的实时数据信道列表", hidden = true)
  private List<Long> excludedDataTopicIds = null;

  public QueryPublishedResourceRequest() {
  }

  public QueryPublishedResourceRequest(String name, Long tagId, Long treeId,
      String responsibleOrganizationId, String type, Integer subscribeStatus) {
    this.name = name;
    this.tagId = tagId;
    this.treeId = treeId;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.type = type;
    this.subscribeStatus = subscribeStatus;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  public Long getTreeId() {
    return treeId;
  }

  public void setTreeId(Long treeId) {
    this.treeId = treeId;
  }

  public String getResponsibleOrganizationId() {
    return responsibleOrganizationId;
  }

  public void setResponsibleOrganizationId(String responsibleOrganizationId) {
    this.responsibleOrganizationId = responsibleOrganizationId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getSubscribeStatus() {
    return subscribeStatus;
  }

  public void setSubscribeStatus(Integer subscribeStatus) {
    this.subscribeStatus = subscribeStatus;
  }

  public List<Long> getDataResourceIds() {
    return dataResourceIds;
  }

  public void setDataResourceIds(List<Long> dataResourceIds) {
    this.dataResourceIds = dataResourceIds;
  }

  public List<Long> getExcludedDataResourceIds() {
    return excludedDataResourceIds;
  }

  public void setExcludedDataResourceIds(List<Long> excludedDataResourceIds) {
    this.excludedDataResourceIds = excludedDataResourceIds;
  }

  public List<Long> getDocumentIds() {
    return documentIds;
  }

  public void setDocumentIds(List<Long> documentIds) {
    this.documentIds = documentIds;
  }

  public List<Long> getExcludedDocumentIds() {
    return excludedDocumentIds;
  }

  public void setExcludedDocumentIds(List<Long> excludedDocumentIds) {
    this.excludedDocumentIds = excludedDocumentIds;
  }

  public List<Long> getDataTopicIds() {
    return dataTopicIds;
  }

  public void setDataTopicIds(List<Long> dataTopicIds) {
    this.dataTopicIds = dataTopicIds;
  }

  public List<Long> getExcludedDataTopicIds() {
    return excludedDataTopicIds;
  }

  public void setExcludedDataTopicIds(List<Long> excludedDataTopicIds) {
    this.excludedDataTopicIds = excludedDataTopicIds;
  }
}
