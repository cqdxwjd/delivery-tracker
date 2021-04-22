package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.constant.CommonConst;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhangws 2019/07/05
 */
@ApiModel(description = "作业概要对象")
public class JobSummaryDto implements Serializable {

  @ApiModelProperty("作业ID")
  private Long jobId;

  @ApiModelProperty("作业名称")
  private String jobName;

  @ApiModelProperty("作业类型")
  private String jobType;

  @ApiModelProperty("来源")
  private String source;

  @ApiModelProperty("目标")
  private String target;

  @ApiModelProperty("近7天失败任务的个数")
  private Long failTaskCount;

  @ApiModelProperty(value = "调度周期（分钟、小时、日、周、月、仅一次)", example = "日")
  private String cycle;

  @ApiModelProperty("作业状态")
  private Integer jobStatus;

  @ApiModelProperty("生效日期（开始）")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date startTime;

  @ApiModelProperty("生效日期（结束）")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date endTime;

  public JobSummaryDto() {
  }

  public JobSummaryDto(Long jobId,
      String jobName,
      String jobType,
      String source,
      String target,
      Long failTaskCount,
      String cycle,
      Integer jobStatus,
      Date startTime,
      Date endTime) {
    this.jobId = jobId;
    this.jobName = jobName;
    this.jobType = jobType;
    this.source = source;
    this.target = target;
    this.failTaskCount = failTaskCount;
    this.cycle = cycle;
    this.jobStatus = jobStatus;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Long getJobId() {
    return jobId;
  }

  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Long getFailTaskCount() {
    return failTaskCount;
  }

  public void setFailTaskCount(Long failTaskCount) {
    this.failTaskCount = failTaskCount;
  }

  public String getCycle() {
    return cycle;
  }

  public void setCycle(String cycle) {
    this.cycle = cycle;
  }

  public Integer getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(Integer jobStatus) {
    this.jobStatus = jobStatus;
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

  @Override
  public String toString() {
    return "JobSummaryDto{" +
        "jobId=" + jobId +
        ", jobName='" + jobName + '\'' +
        ", jobType=" + jobType +
        ", failTaskCount=" + failTaskCount +
        ", jobStatus=" + jobStatus +
        '}';
  }
}
