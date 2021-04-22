package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * @author david
 * @date 2020/9/27 3:10 下午
 */
@ApiModel(description = "修改状态")
public class UpdateStatusRequestDto implements Serializable {
  @ApiModelProperty(required = true, name = "状态")
  private Integer status;

  @ApiParam(value = "修改原因")
  private String reason;

  @ApiParam(value = "是否停止资源已启动的作业")
  private Boolean stopJobs;

  public UpdateStatusRequestDto() {
  }

  public UpdateStatusRequestDto(Integer status, String reason, Boolean stopJobs) {
    this.status = status;
    this.reason = reason;
    this.stopJobs = stopJobs;
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

  public Boolean getStopJobs() {
    return stopJobs;
  }

  public void setStopJobs(Boolean stopJobs) {
    this.stopJobs = stopJobs;
  }
}
