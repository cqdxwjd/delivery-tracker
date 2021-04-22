package com.yunli.bigdata.dsep.service.common.dto.tag;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/17 17:28
 */
@ApiModel(description = "添加数据标签参数对象")
public class AddDataTagDto implements Serializable {

  @ApiModelProperty(value = "标签树ID", required = true)
  private Long treeId;

  @ApiModelProperty("父标签ID")
  private Long parentId;

  @ApiModelProperty("标签名称")
  private String name;

  @ApiModelProperty("标签描述")
  private String description;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
