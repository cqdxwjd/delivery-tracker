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
public class TaskDetailResponse implements Serializable {

  @ApiModelProperty("任务ID")
  private Long id;

  @ApiModelProperty("作业ID")
  private Long jobId;

  @ApiModelProperty("数据作业名称")
  private String jobName;

  @ApiModelProperty("数据作业类型")
  private String jobType;

  @ApiModelProperty("调度周期")
  private String cycle;

  @ApiModelProperty("来源")
  private String source;

  @ApiModelProperty("目标")
  private String target;

  @ApiModelProperty("任务模式，默认0 (0: 自动生成, 1: 手动创建)")
  private Integer mode;

  @ApiModelProperty("任务类型，默认0 (0: 普通, 1: 导入临时表, 2: 质检, 3: 审批, 4: 导入正式表)")
  private Integer type;

  @ApiModelProperty("任务标签")
  private String tag;

  @ApiModelProperty("任务优先级, 按照优先级进行排序，用于task的执行顺序，值越大优先级越小")
  private Integer priority;

  @ApiModelProperty("任务状态，默认0 (0: 已创建, 1: 就绪, 2: 运行中, 3: 暂停中, 4: 成功, 5: 失败)")
  private Integer status;

  @ApiModelProperty("计划运行时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date planTime;

  @ApiModelProperty("实际开始时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date startTime;

  @ApiModelProperty("实际结束时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date endTime;

  @ApiModelProperty("导入数据量")
  private Long importCount;

  @ApiModelProperty("导出数据量")
  private Long exportCount;

  @ApiModelProperty("任务执行命令")
  private String taskCmd;

  @ApiModelProperty("任务批次(补数据、质检执行第几次)")
  private String batchNumber;

  @ApiModelProperty("失败原因")
  private String reason;

  @ApiModelProperty("创建时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date createTime;

  @ApiModelProperty("更新时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date updateTime;

  public TaskDetailResponse() {
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

  public String getCycle() {
    return cycle;
  }

  public void setCycle(String cycle) {
    this.cycle = cycle;
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

  public Integer getMode() {
    return mode;
  }

  public void setMode(Integer mode) {
    this.mode = mode;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
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

  public Long getImportCount() {
    return importCount;
  }

  public void setImportCount(Long importCount) {
    this.importCount = importCount;
  }

  public Long getExportCount() {
    return exportCount;
  }

  public void setExportCount(Long exportCount) {
    this.exportCount = exportCount;
  }

  public String getTaskCmd() {
    return taskCmd;
  }

  public void setTaskCmd(String taskCmd) {
    this.taskCmd = taskCmd;
  }

  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDetailResponse taskInfoDto = (TaskDetailResponse) o;
    return id.equals(taskInfoDto.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "TaskInfoDto{" +
        "id=" + id +
        ", jobId=" + jobId +
        ", mode=" + mode +
        ", type=" + type +
        ", tag='" + tag + '\'' +
        ", priority=" + priority +
        ", status=" + status +
        ", planTime=" + planTime +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", taskCmd='" + taskCmd + '\'' +
        ", batchNumber='" + batchNumber + '\'' +
        ", reason='" + reason + '\'' +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        '}';
  }
}
