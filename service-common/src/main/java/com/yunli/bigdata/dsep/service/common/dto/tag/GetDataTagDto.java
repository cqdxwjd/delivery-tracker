package com.yunli.bigdata.dsep.service.common.dto.tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 查询数据标签参数对象
 * @author wei
 */
@ApiModel(description = "查询数据标签参数对象")
public class GetDataTagDto implements Serializable {
  @ApiModelProperty("标签ID")
  private Long id;

  @ApiModelProperty("标签树ID")
  private Long treeId;

  @ApiModelProperty("标签父ID")
  private Long parentId;

  public GetDataTagDto() {
  }

  public GetDataTagDto(Long id, Long treeId, Long parentId) {
    this.id = id;
    this.treeId = treeId;
    this.parentId = parentId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
}
