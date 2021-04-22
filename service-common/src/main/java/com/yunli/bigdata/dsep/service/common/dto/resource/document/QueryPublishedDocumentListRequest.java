package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhangws
 */
public class QueryPublishedDocumentListRequest implements Serializable {

  @ApiModelProperty("文档名称")
  private String name;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long tagId;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long treeId;

  @ApiModelProperty(value = "是否关联目录", example = "false")
  private Boolean inTag;

  /**
   * 查询此资源的用户对此资源的访问权限
   **/
  @ApiModelProperty("查询此资源的用户对此资源的访问权限（未申请:0 审批中:1 已授权:2）")
  private Integer subscribeStatus;

  @ApiModelProperty("是否为可文件上传的文件夹列表的查询（true:查询可文件上传的文件夹的列表, false:查询可下载文件的文件夹的列表, null:正常查询）")
  private Boolean inputByJob;

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
