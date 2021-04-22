package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 查询TOPIC参数对象
 * @author david
 */
@ApiModel(description = "查询TOPIC参数对象")
public class QueryDataTopicRequestDto implements Serializable {

  @ApiModelProperty("信道编码")
  private String topicCode;

  @ApiModelProperty("信道名称")
  private String topicName;

  @ApiModelProperty("信道状态")
  private Integer status;

  @ApiModelProperty("组织机构代码")
  private String responsibleOrganizationId;

  @ApiModelProperty("标签ID")
  private Long tagId;

  @ApiModelProperty("是否含标签")
  private Boolean inTag;

  @ApiModelProperty(value = "指定在哪个目录的编码", example = "1")
  private Long inWhichTagId;

  @ApiModelProperty("是否有数据")
  private Boolean hasData;

  @ApiModelProperty("信道编码数组")
  private List<Long> topicIds;

  @ApiModelProperty("作业查询")
  private Boolean queryForJob;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long treeId;

  public QueryDataTopicRequestDto() {
  }

  public QueryDataTopicRequestDto(String topicCode, String topicName, Long tagId) {
    this.topicCode = topicCode;
    this.topicName = topicName;
    this.tagId = tagId;
  }

  public QueryDataTopicRequestDto(String topicCode, String topicName, Integer status,
      String responsibleOrganizationId, Long tagId, Boolean inTag) {
    this.topicCode = topicCode;
    this.topicName = topicName;
    this.status = status;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.tagId = tagId;
    this.inTag = inTag;
  }


  /**
   * 数据表状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）
   * @return status
   **/
  @ApiModelProperty(value = "数据表状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）", example = "0")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  /**
   * 资源责任组织ID
   * @return responsibleOrganizationId
   **/
  @ApiModelProperty(value = "资源责任组织ID")
  public String getResponsibleOrganizationId() {
    return responsibleOrganizationId;
  }

  public void setResponsibleOrganizationId(String responsibleOrganizationId) {
    this.responsibleOrganizationId = responsibleOrganizationId;
  }

  /**
   * 目录ID
   * @return 目录ID
   **/
  @ApiModelProperty(value = "目录ID", example = "0")
  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  /**
   * 是否关联目录
   * @return 是否关联目录
   **/
  @ApiModelProperty(value = "是否关联目录")
  public Boolean getInTag() {
    return inTag;
  }

  public void setInTag(Boolean inTag) {
    this.inTag = inTag;
  }

  public Boolean getHasData() {
    return hasData;
  }

  public void setHasData(Boolean hasData) {
    this.hasData = hasData;
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

  public List<Long> getTopicIds() {
    return topicIds;
  }

  public void setTopicIds(List<Long> topicIds) {
    this.topicIds = topicIds;
  }

  public Long getInWhichTagId() {
    return inWhichTagId;
  }

  public void setInWhichTagId(Long inWhichTagId) {
    this.inWhichTagId = inWhichTagId;
  }

  public Boolean getQueryForJob() {
    return queryForJob;
  }

  public void setQueryForJob(Boolean queryForJob) {
    this.queryForJob = queryForJob;
  }
}
