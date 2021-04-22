package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 查询数据表参数对象
 * @author wei
 */
@ApiModel(description = "查询发布后的数据表参数对象")
public class QueryPublishedDataResourceRequestDto implements Serializable {
  @ApiModelProperty("资源表名称（英文）")
  private String nameEn;

  @ApiModelProperty("资源表名称（中文）")
  private String nameCn;

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

  @ApiModelProperty("是否为库表导入的查询（true:查询库表导入时的目标表列表, false:查询库表导出的来源表列表, null:正常查询）")
  private Boolean inputByJob;

  public QueryPublishedDataResourceRequestDto() {
  }

  public QueryPublishedDataResourceRequestDto(String nameEn, String nameCn, Long tagId, Long treeId,
      Integer subscribeStatus, Boolean inTag) {
    this.nameEn = nameEn;
    this.nameCn = nameCn;
    this.tagId = tagId;
    this.treeId = treeId;
    this.subscribeStatus = subscribeStatus;
    this.inTag = inTag;
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
