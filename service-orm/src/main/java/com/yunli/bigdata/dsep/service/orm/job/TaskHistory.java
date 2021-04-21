package com.yunli.bigdata.dsep.service.orm.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhangws 2019/12/26
 */
@Entity
@Table(name = "task_history")
@EntityListeners(AuditingEntityListener.class)
public class TaskHistory implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long taskId;

  /**
   * 任务执行命令
   */
  @JsonIgnore
  @Column
  private byte[] taskCmd;

  /**
   * 失败原因
   */
  @Column
  private byte[] reason;

  /**
   * 创建时间
   */
  @CreatedDate
  @Column
  private Date createTime;

  public TaskHistory() {
  }

  public TaskHistory(Long taskId, byte[] taskCmd) {
    this.taskId = taskId;
    if (null != taskCmd) {
      this.taskCmd = Arrays.copyOf(taskCmd, taskCmd.length);
    } else {
      this.taskCmd = new byte[0];
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTaskId() {
    return taskId;
  }

  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  public byte[] getTaskCmd() {
    return taskCmd == null ? null : Arrays.copyOf(taskCmd,  taskCmd.length);
  }

  public void setTaskCmd(byte[] taskCmd) {
    if (null != taskCmd) {
      this.taskCmd = Arrays.copyOf(taskCmd, taskCmd.length);
    } else {
      this.taskCmd = new byte[0];
    }
  }

  public byte[] getReason() {
    return reason == null ? null : Arrays.copyOf(reason,  reason.length);
  }

  public void setReason(byte[] reason) {
    if (null != reason) {
      this.reason = Arrays.copyOf(reason, reason.length);
    } else {
      this.reason = new byte[0];
    }
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskHistory taskHistory = (TaskHistory) o;
    return id.equals(taskHistory.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "TaskHistory{" +
        "id=" + id +
        ", taskId=" + taskId +
        ", createTime=" + createTime +
        '}';
  }
}
