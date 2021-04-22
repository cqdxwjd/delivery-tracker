package com.yunli.bigdata.dsep.service.common.dto.tag;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 查询数据标签参数对象
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/18 15:36
 */
@ApiModel(description = "查询数据标签参数对象")
public class QueryDataTagDto implements Serializable {
  @ApiModelProperty("标签树ID")
  private Long treeId;

  @ApiModelProperty("标签父ID")
  private Long parentId;

  @ApiModelProperty("标签名称")
  private String name;

  @ApiModelProperty(value = "发布状态: 0-未发布(初始状态), 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布", allowableValues = "0,1,2,3,4")
  private Integer status;

  @ApiModelProperty(value = "是否已关联资源: false-未关联, true-已关联", allowableValues = "false,true")
  private Boolean relation;

  @ApiModelProperty("是否已发布")
  private Boolean published;

  public QueryDataTagDto() {
  }

  public Long getTreeId() {
    return treeId;
  }

  public void setTreeId(Long treeId) {
    this.treeId = treeId;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
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

  public Boolean getRelation() {
    return relation;
  }

  public void setRelation(Boolean relation) {
    this.relation = relation;
  }

  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }
}
