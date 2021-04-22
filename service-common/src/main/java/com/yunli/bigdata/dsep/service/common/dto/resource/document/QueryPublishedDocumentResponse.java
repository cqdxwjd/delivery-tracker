package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.constant.SubscribeStatus;
import com.yunli.bigdata.dsep.service.common.dto.resource.label.LabelCatalog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wei
 */
@ApiModel(description = "查询文档结果对象列表")
public class QueryPublishedDocumentResponse implements Serializable {
  /**
   * 文档ID
   **/
  @ApiModelProperty("文档ID")
  private Long id;

  @ApiModelProperty("文档名称")
  private String name;

  @ApiModelProperty("资源责任人ID")
  private String responsibleId;

  @ApiModelProperty("资源责任人名称")
  private String responsibleName;

  @ApiModelProperty("资源责任组织ID")
  private String responsibleOrganizationId;

  @ApiModelProperty("资源责任组织名称")
  private String responsibleOrganizationName;

  @ApiModelProperty("资源描述")
  private String description;

  @ApiModelProperty("共享类型（0-有条件共享，1-无条件共享，2-不予共享）")
  private Integer sharingType;

  @ApiModelProperty("共享条件")
  private String sharingCondition;

  @ApiModelProperty("发布时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date publishedTime;

  @ApiModelProperty("创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @ApiModelProperty("更新时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  @ApiModelProperty("文件下载次数")
  private Long sharingTimes;

  @ApiModelProperty("文件数量")
  private Long count;

  @ApiModelProperty("节点ID")
  private Long nid = 0L;

  @ApiModelProperty("内容明细")
  private List<Node> children = new ArrayList<>();

  @ApiModelProperty("标签属性")
  private List<LabelCatalog> labels;

  /**
   * 查询此资源的用户对此资源的访问权限
   **/
  @ApiModelProperty("查询此资源的用户对此资源的访问权限（未申请:0 审批中:1 已授权:2）")
  private Integer subscribeStatus = SubscribeStatus.Default.getValue();

  public QueryPublishedDocumentResponse() {
  }

  public QueryPublishedDocumentResponse(Long id, String name, String responsibleId,
      String responsibleName, String responsibleOrganizationId,
      String responsibleOrganizationName, String description, Integer sharingType, String sharingCondition,
      Date publishedTime, Date createTime, Date updateTime, Long sharingTimes, Long count) {
    this.id = id;
    this.name = name;
    this.responsibleId = responsibleId;
    this.responsibleName = responsibleName;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.responsibleOrganizationName = responsibleOrganizationName;
    this.description = description;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.publishedTime = publishedTime;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.sharingTimes = sharingTimes;
    this.count = count;
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

  public Long getSharingTimes() {
    return sharingTimes;
  }

  public void setSharingTimes(Long sharingTimes) {
    this.sharingTimes = sharingTimes;
  }

  public Integer getSubscribeStatus() {
    return subscribeStatus;
  }

  public void setSubscribeStatus(Integer subscribeStatus) {
    this.subscribeStatus = subscribeStatus;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
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

  public List<LabelCatalog> getLabels() {
    return labels;
  }

  public void setLabels(List<LabelCatalog> labels) {
    this.labels = labels;
  }
}
