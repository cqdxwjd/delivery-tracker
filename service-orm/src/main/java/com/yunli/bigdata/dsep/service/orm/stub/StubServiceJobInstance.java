package com.yunli.bigdata.dsep.service.orm.stub;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 实时作业实例表
 *
 * @author david
 * @email fudawei@yunlizhihui.com
 * @date 2020-06-11 11:40:26
 */
@Entity
@Table(name = "stub_service_job_instance")
@EntityListeners(AuditingEntityListener.class)
public class StubServiceJobInstance implements Serializable {
  private static final long serialVersionUID = 1L;

  //实例ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //job编码
  @Column(name = "job_id")
  private Long jobId;

  //分区信息
  @Column(name = "partitions")
  private String partitions;

  //开始时间
  @Column(name = "start_time")
  @CreatedDate
  private Date startTime;

  //结束时间
  @Column(name = "end_time")
  private Date endTime;

  //目标描述
  @Column(name = "description")
  private String description;

  //作业状态(0: 运行中, 1: 运行失败, 2: 已完成, 9: 逻辑删除)
  @Column(name = "status")
  private Integer status;

  //创建时间
  @Column(name = "create_time")
  @CreatedDate
  private Date createTime;

  //更新时间
  @Column(name = "update_time")
  @UpdateTimestamp
  private Date updateTime;

  public StubServiceJobInstance() {
  }

  public StubServiceJobInstance(Long jobId, String partitions, Date startTime, String description,
      Integer status) {
    this.jobId = jobId;
    this.partitions = partitions;
    this.startTime = startTime;
    this.description = description;
    this.status = status;
  }

  /**
   * 设置：实例ID
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取：实例ID
   */
  public Long getId() {
    return id;
  }

  /**
   * 设置：job编码
   */
  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  /**
   * 获取：job编码
   */
  public Long getJobId() {
    return jobId;
  }

  /**
   * 设置：分区信息
   */
  public void setPartitions(String partitions) {
    this.partitions = partitions;
  }

  /**
   * 获取：分区信息
   */
  public String getPartitions() {
    return partitions;
  }

  /**
   * 设置：开始时间
   */
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  /**
   * 获取：开始时间
   */
  public Date getStartTime() {
    return startTime;
  }

  /**
   * 设置：结束时间
   */
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  /**
   * 获取：结束时间
   */
  public Date getEndTime() {
    return endTime;
  }

  /**
   * 设置：目标描述
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 获取：目标描述
   */
  public String getDescription() {
    return description;
  }

  /**
   * 设置：作业状态(0: 运行中, 1: 运行失败, 2: 已完成, 9: 逻辑删除)
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * 获取：作业状态(0: 运行中, 1: 运行失败, 2: 已完成, 9: 逻辑删除)
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * 设置：创建时间
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 获取：创建时间
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * 设置：更新时间
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * 获取：更新时间
   */
  public Date getUpdateTime() {
    return updateTime;
  }
}
