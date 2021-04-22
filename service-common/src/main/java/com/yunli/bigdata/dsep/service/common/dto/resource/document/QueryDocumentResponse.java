package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.dto.resource.label.LabelCatalog;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhangws
 */
public class QueryDocumentResponse implements Serializable {
  /**
   * 数据表表ID
   **/
  @ApiModelProperty("ID")
  private Long id;

  @ApiModelProperty("文档名称")
  private String name;

  /**
   * 数据表状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）
   **/
  @ApiModelProperty("数据表状态（0-未发布, 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中）")
  private Integer status;

  @ApiModelProperty("资源责任组织ID")
  private String responsibleOrganizationId;

  @ApiModelProperty("资源责任组织名称")
  private String responsibleOrganizationName;

  @ApiModelProperty("资源责任人ID")
  private String responsibleId;

  @ApiModelProperty("资源责任人名称")
  private String responsibleName;

  @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
  private Integer sharingType;

  @ApiModelProperty("共享条件")
  private String sharingCondition;

  @ApiModelProperty("资源描述")
  private String description;

  @ApiModelProperty("发布时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date publishedTime;

  @ApiModelProperty("创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @ApiModelProperty("更新时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  @ApiModelProperty("标签属性")
  private List<LabelCatalog> labels;

  @ApiModelProperty("节点ID")
  private Long nid = 0L;

  @ApiModelProperty("内容明细")
  private List<Node> children;

  /**
   * 文档关联的目录ID的列表
   **/
  @ApiModelProperty("文档关联的目录ID的列表")
  private List<Long> tagIds;

  /**
   * 文档关联的目录ID的列表
   **/
  @ApiModelProperty("文档关联的目录名称列表")
  private List<String> tagNames;

  @ApiModelProperty("文件数")
  private Long count;

  public QueryDocumentResponse() {
  }

  public QueryDocumentResponse(Long id, String name, Integer status, String responsibleOrganizationId,
      String responsibleOrganizationName, String responsibleId, String responsibleName, Integer sharingType,
      String sharingCondition, String description, Date publishedTime, Date createTime, Date updateTime,
      List<Long> tagIds, List<String> tagNames, Long count) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleOrganizationName = responsibleOrganizationName;
    this.responsibleId = responsibleId;
    this.responsibleName = responsibleName;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.description = description;
    this.publishedTime = publishedTime;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.tagIds = tagIds;
    this.tagNames = tagNames;
    this.count = count;
    this.nid = 0L;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
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

  public Date getPublishedTime() {
    return publishedTime;
  }

  public void setPublishedTime(Date publishedTime) {
    this.publishedTime = publishedTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public List<LabelCatalog> getLabels() {
    return labels;
  }

  public void setLabels(List<LabelCatalog> labels) {
    this.labels = labels;
  }

  public Long getNid() {
    return nid;
  }

  public void setNid(Long nid) {
    this.nid = nid;
  }

  public List<Node> getChildren() {
    return children;
  }

  public void setChildren(List<Node> children) {
    this.children = children;
  }

  public List<Long> getTagIds() {
    return tagIds;
  }

  public void setTagIds(List<Long> tagIds) {
    this.tagIds = tagIds;
  }

  public List<String> getTagNames() {
    return tagNames;
  }

  public void setTagNames(List<String> tagNames) {
    this.tagNames = tagNames;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }
}
