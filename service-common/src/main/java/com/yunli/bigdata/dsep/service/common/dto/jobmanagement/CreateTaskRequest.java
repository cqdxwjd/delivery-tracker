package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.constant.CommonConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: jiangxunyu
 * @CreateDate: 2019/7/15 13:05
 */
@ApiModel(description = "补数据参数对象")
public class CreateTaskRequest implements Serializable {

  @ApiModelProperty(value = "任务开始时间", required = true)
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  @NotNull(message = "开始时间不能为空")
  private Date startDate;

  @ApiModelProperty(value = "任务结束时间", required = true)
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  @NotNull(message = "开始时间不能为空")
  private Date endDate;

  @ApiModelProperty(value = "按调度周期生成作业任务", required = true)
  @NotNull(message = "按调度周期生成作业任务不能为空")
  private Boolean basedScheduling;

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Boolean getBasedScheduling() {
    return basedScheduling;
  }

  public void setBasedScheduling(Boolean basedScheduling) {
    this.basedScheduling = basedScheduling;
  }
}
