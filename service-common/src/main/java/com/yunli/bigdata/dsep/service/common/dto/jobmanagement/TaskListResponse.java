package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.constant.CommonConst;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhangws 2019/07/05
 */
public class TaskListResponse implements Serializable {

  @ApiModelProperty("任务ID")
  private Long id;

  @ApiModelProperty("作业ID")
  private Long jobId;

  @ApiModelProperty("调度类型，默认0 (0: 自动调度, 1: 手动触发)")
  private Integer mode;

  @ApiModelProperty("任务类型，默认0 (0: 批量任务, 1: 实时任务)")
  private Integer taskType;

  @ApiModelProperty("计划运行时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date planTime;

  @ApiModelProperty("实际开始时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date startTime;

  @ApiModelProperty("实际结束时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date endTime;

  @ApiModelProperty("任务状态，默认0 (0: 已创建, 1: 就绪, 2: 运行中, 3: 暂停中, 4: 成功, 5: 失败)")
  private Integer status;

  public TaskListResponse() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getJobId() {
    return jobId;
  }

  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  public Integer getMode() {
    return mode;
  }

  public void setMode(Integer mode) {
    this.mode = mode;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getPlanTime() {
    return planTime;
  }

  public void setPlanTime(Date planTime) {
    this.planTime = planTime;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Integer getTaskType() {
    return taskType;
  }

  public void setTaskType(Integer taskType) {
    this.taskType = taskType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskListResponse taskInfoDto = (TaskListResponse) o;
    return id.equals(taskInfoDto.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "TaskListResponse{" +
        "id=" + id +
        ", jobId=" + jobId +
        ", mode=" + mode +
        ", planTime=" + planTime +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", status=" + status +
        '}';
  }
}
