package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 查询TOPIC参数对象
 * @author david
 */
@ApiModel(description = "查询TOPIC参数对象")
public class QueryPublishedDataTopicRequestDto implements Serializable {

  private String topicCode;

  private String topicName;

  @ApiModelProperty(value = "目录ID")
  private Long tagId;

  @ApiModelProperty(value = "目录树ID")
  private Long treeId;

  @ApiModelProperty(value = "是否关联目录", example = "false")
  private Boolean inTag;

  /**
   * 查询此资源的用户对此资源的访问权限
   **/
  @ApiModelProperty("查询此资源的用户对此资源的访问权限（未申请:0 审批中:1 已授权:2）")
  private Integer subscribeStatus;

  @ApiModelProperty("是否为可写入数据的实时数据通道的列表的查询（true:查询可写入数据的实时数据通道的列表, false:查询可读取数据的实时数据通道的列表, null:正常查询）")
  private Boolean inputByJob;

  public QueryPublishedDataTopicRequestDto() {
  }

  public QueryPublishedDataTopicRequestDto(String topicCode, String topicName, Long tagId, Long treeId,
      Boolean inTag,
      Integer subscribeStatus) {
    this.topicCode = topicCode;
    this.topicName = topicName;
    this.tagId = tagId;
    this.treeId = treeId;
    this.inTag = inTag;
    this.subscribeStatus = subscribeStatus;
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

  public Integer getSubscribeStatus() {
    return subscribeStatus;
  }

  public void setSubscribeStatus(Integer subscribeStatus) {
    this.subscribeStatus = subscribeStatus;
  }

  public Boolean getInTag() {
    return inTag;
  }

  public void setInTag(Boolean inTag) {
    this.inTag = inTag;
  }

  public Boolean getInputByJob() {
    return inputByJob;
  }

  public void setInputByJob(Boolean inputByJob) {
    this.inputByJob = inputByJob;
  }
}
