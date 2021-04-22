package com.yunli.bigdata.dsep.service.common.dto.tag;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 修改数据标签参数对象
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/17 17:28
 */
@ApiModel(description = "修改数据标签参数对象")
public class EditDataTagDto implements Serializable {

  //    @ApiModelProperty("标签树ID")
//    private Long treeId;
  @ApiModelProperty("标签名称")
  private String name;

  @ApiModelProperty("父标签ID")
  private Long parentId;

  @ApiModelProperty("标签描述")
  private String description;

  public EditDataTagDto() {
  }

  public EditDataTagDto(String name, Long parentId, String description) {
    this.name = name;
    this.parentId = parentId;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
