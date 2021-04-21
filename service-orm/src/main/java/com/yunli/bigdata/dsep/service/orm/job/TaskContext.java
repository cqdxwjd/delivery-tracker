package com.yunli.bigdata.dsep.service.orm.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhangws 2019/12/26
 */
@Entity
@Table(name = "task_context")
@EntityListeners(AuditingEntityListener.class)
public class TaskContext implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 作业ID
   */
  @Column(nullable = false)
  private Long jobId;

  /**
   * 任务模式，默认0 (0: 自动生成, 1: 手动创建)
   */
  @Column(nullable = false)
  private Integer mode;

  /**
   * 任务类型，默认0 (0: 普通, 1: 导入临时表, 2: 质检, 3: 审批, 4: 导入正式表)
   */
  @Column(nullable = false)
  private Integer type;

  /**
   * 任务优先级, 按照优先级进行排序，用于task的执行顺序，值越大优先级越小
   */
  @Column
  private Long priority;

  /**
   * 任务标签
   */
  @Column(nullable = false)
  private String tag;

  /**
   * 任务批次(补数据、质检执行第几次)
   */
  @Column
  private String batchNumber;

  /**
   * 业务时间
   */
  @Column
  private Date businessTime;

  /**
   * 计划运行时间
   */
  @Column
  private Date planTime;

  /**
   * 超时时间
   */
  @Column
  private Integer timeout;

  /**
   * 实际开始时间
   */
  @Column
  private Date startTime;

  /**
   * 实际结束时间
   */
  @Column
  private Date endTime;

  /**
   * 任务执行命令
   */
  @JsonIgnore
  @Column
  private String taskParams;

  @Column
  private String source;

  @Column
  private String target;

  @Column
  private Long readCount;

  @Column
  private Long failCount;

  /**
   * 任务状态，默认0 (0: 已创建, 1: 就绪, 2: 运行中, 3: 暂停中, 4: 成功, 5: 失败)
   */
  @Column
  private Integer status;

  /**
   * 创建时间
   */
  @CreatedDate
  @Column
  private Date createTime;

  /**
   * 更新时间
   */
  @LastModifiedDate
  @Column
  private Date updateTime;

  public TaskContext() {
  }

  public TaskContext(Integer status) {
    this.status = status;
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

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Long getPriority() {
    return priority;
  }

  public void setPriority(Long priority) {
    this.priority = priority;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public Date getBusinessTime() {
    return businessTime;
  }

  public void setBusinessTime(Date businessTime) {
    this.businessTime = businessTime;
  }

  public Date getPlanTime() {
    return planTime;
  }

  public void setPlanTime(Date planTime) {
    this.planTime = planTime;
  }

  public Integer getTimeout() {
    return timeout;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
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

  public String getTaskParams() {
    return taskParams;
  }

  public void setTaskParams(String taskParams) {
    this.taskParams = taskParams;
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

  public Long getReadCount() {
    return readCount;
  }

  public void setReadCount(Long readCount) {
    this.readCount = readCount;
  }

  public Long getFailCount() {
    return failCount;
  }

  public void setFailCount(Long failCount) {
    this.failCount = failCount;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
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
    TaskContext taskInfo = (TaskContext) o;
    return id.equals(taskInfo.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "TaskContext{" +
        "id=" + id +
        ", jobId=" + jobId +
        ", mode=" + mode +
        ", type=" + type +
        ", priority=" + priority +
        ", tag='" + tag + '\'' +
        ", batchNumber='" + batchNumber + '\'' +
        ", planTime=" + planTime +
        ", timeout=" + timeout +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", taskParams='" + taskParams + '\'' +
        ", readerTable='" + source + '\'' +
        ", writerTable='" + target + '\'' +
        ", status=" + status +
        '}';
  }
}
