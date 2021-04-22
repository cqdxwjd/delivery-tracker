package com.yunli.bigdata.dsep.service.common.dto.tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description: 变更数据标签参数对象
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/17 17:19
 */
@ApiModel(description = "变更数据标签参数对象")
public class AlterDataTagDto implements Serializable {
  @ApiModelProperty("标签名称")
  private String name;

  @ApiModelProperty("父标签ID")
  private Long parentId;

  // @ApiModelProperty("标签树ID")
  // private Long treeId;

  @ApiModelProperty("描述信息")
  private String description;

  @ApiModelProperty("操作说明")
  private String reason;

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

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
