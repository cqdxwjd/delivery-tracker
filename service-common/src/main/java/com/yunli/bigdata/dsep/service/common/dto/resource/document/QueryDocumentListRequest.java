package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhangws
 */
public class QueryDocumentListRequest implements Serializable {

  @ApiModelProperty(value = "文档名称")
  private String name;

  @ApiModelProperty(value = "状态")
  private Integer status;

  @ApiModelProperty(value = "是否关联目录")
  private Boolean inTag;

  @ApiModelProperty(value = "指定在哪个目录的编码", example = "1")
  private Long inWhichTagId;

  @ApiModelProperty(value = "目录树ID", example = "1")
  private Long treeId;

  @ApiModelProperty(value = "目录ID", example = "1")
  private Long tagId;

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

  public Boolean getInTag() {
    return inTag;
  }

  public void setInTag(Boolean inTag) {
    this.inTag = inTag;
  }

  public Long getTreeId() {
    return treeId;
  }

  public void setTreeId(Long treeId) {
    this.treeId = treeId;
  }

  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  public Long getInWhichTagId() {
    return inWhichTagId;
  }

  public void setInWhichTagId(Long inWhichTagId) {
    this.inWhichTagId = inWhichTagId;
  }
}
