package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 查询数据表参数对象
 * @author wei
 */
@ApiModel(description = "查询数据表参数对象")
public class QueryDataResourceRequestDto implements Serializable {

  private String nameEn;

  private String nameCn;

  private Integer status;

  private String responsibleOrganizationId;

  private Long tagId;

  @ApiModelProperty(value = "指定在哪个目录的编码", example = "1")
  private Long inWhichTagId;

  private Boolean inTag;

  private Boolean hasData;

  private List<Long> resourceIds;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long treeId;

  public QueryDataResourceRequestDto() {
  }

  public QueryDataResourceRequestDto(String nameEn, String nameCn, Long tagId) {
    this.nameEn = nameEn;
    this.nameCn = nameCn;
    this.tagId = tagId;
  }

  public QueryDataResourceRequestDto(String nameEn, String nameCn, Integer status,
      String responsibleOrganizationId, Long tagId, Boolean inTag) {
    this.nameEn = nameEn;
    this.nameCn = nameCn;
    this.status = status;
    this.responsibleOrganizationId = responsibleOrganizationId;
    this.tagId = tagId;
    this.inTag = inTag;
  }

  /**
   * 资源表名称（英文）
   * @return nameEn
   **/
  @ApiModelProperty("资源表名称（英文）")
  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }


  /**
   * 资源表名称（中文）
   * @return nameCn
   **/
  @ApiModelProperty("资源表名称（中文）")
  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
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

  public List<Long> getResourceIds() {
    return resourceIds;
  }

  public void setResourceIds(List<Long> resourceIds) {
    this.resourceIds = resourceIds;
  }

  public Long getTreeId() {
    return treeId;
  }

  public void setTreeId(Long treeId) {
    this.treeId = treeId;
  }

  public Long getInWhichTagId() {
    return inWhichTagId;
  }

  public void setInWhichTagId(Long inWhichTagId) {
    this.inWhichTagId = inWhichTagId;
  }
}
