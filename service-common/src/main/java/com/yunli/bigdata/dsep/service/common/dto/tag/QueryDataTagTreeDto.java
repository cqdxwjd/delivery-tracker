package com.yunli.bigdata.dsep.service.common.dto.tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description: 查询数据标签树参数对象
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/18 15:39
 */
@ApiModel(description = "查询数据标签树对象")
public class QueryDataTagTreeDto implements Serializable {

  @ApiModelProperty("标签树名称")
  private String name;

  @ApiModelProperty(value = "是否已关联标签: false-未关联, true-已关联", allowableValues = "false,true")
  private Boolean relation;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getRelation() {
    return relation;
  }

  public void setRelation(Boolean relation) {
    this.relation = relation;
  }
}
