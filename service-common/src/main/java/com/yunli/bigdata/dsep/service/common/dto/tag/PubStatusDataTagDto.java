package com.yunli.bigdata.dsep.service.common.dto.tag;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 发布状态数据标签参数对象
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/17 17:08
 */
@ApiModel(description = "设置发布状态数据标签参数对象")
public class PubStatusDataTagDto implements Serializable {

  @ApiModelProperty(value = "标签ID集合", required = true)
  private List<Long> id;

  @ApiModelProperty(value = "发布状态: 0-未发布(初始状态), 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布", required = true)
  private Integer status;

  @ApiModelProperty("操作说明")
  private String reason;

  public List<Long> getId() {
    return id;
  }

  public void setId(List<Long> id) {
    this.id = id;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
