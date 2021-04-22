package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 修改数据表状态的参数对象
 * @author wei
 */
@ApiModel(description = "修改数据表状态的参数对象")
public class UpdateDataResourceStatusRequestDto implements Serializable {

  private List<Long> id;

  private String reason;

  private Integer status;

  private Boolean stopJobs;

  public UpdateDataResourceStatusRequestDto() {
  }

  public UpdateDataResourceStatusRequestDto(List<Long> id, String reason, Integer status, Boolean stopJobs) {
    this.id = id;
    this.reason = reason;
    this.status = status;
    this.stopJobs = stopJobs;
  }

  /**
   * 标签ID集合
   * @return id
   **/
  @ApiModelProperty(required = true, name = "标签ID集合")
  public List<Long> getId() {
    return id;
  }

  public void setId(List<Long> id) {
    this.id = id;
  }


  /**
   * 操作说明
   * @return reason
   **/
  @ApiModelProperty("操作说明")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  /**
   * 状态: 0-未发布(初始状态), 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布
   * @return status
   **/
  @ApiModelProperty(value = "状态: 0-未发布(初始状态), 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布", required = true)
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @ApiModelProperty(value = "是否停止对应数据表已启用的作业")
  public Boolean getStopJobs() {
    return stopJobs;
  }

  public void setStopJobs(Boolean stopJobs) {
    this.stopJobs = stopJobs;
  }
}
