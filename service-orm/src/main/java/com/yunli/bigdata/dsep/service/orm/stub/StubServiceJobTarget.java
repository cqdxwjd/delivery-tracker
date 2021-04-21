package com.yunli.bigdata.dsep.service.orm.stub;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 实时作业目标表
 *
 * @author david
 * @email fudawei@yunlizhihui.com
 * @date 2020-06-11 11:40:26
 */
@Entity
@Table(name = "stub_service_job_target")
@EntityListeners(AuditingEntityListener.class)
public class StubServiceJobTarget implements Serializable {
  private static final long serialVersionUID = 1L;

  //目标ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //job编码
  @Column(name = "job_id")
  private Long jobId;

  //目标类型(0: 总线, 1: HIVE)
  @Column(name = "type")
  private String type;

  //目标描述
  @Column(name = "description")
  private String description;

  //状态(0: 启用, 1: 停用)
  @Column(name = "status")
  private Integer status;

  //目标编码
  @Column(name = "target_id")
  private Long targetId;

  //创建时间
  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  //更新时间
  @UpdateTimestamp
  @Column(name = "update_time")
  private Date updateTime;

  public StubServiceJobTarget() {
  }

  public StubServiceJobTarget(Long jobId, String type, String description, Integer status, Long targetId) {
    this.jobId = jobId;
    this.type = type;
    this.description = description;
    this.status = status;
    this.targetId = targetId;
  }

  /**
   * 设置：目标ID
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取：目标ID
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
   * 设置：目标类型(0: 总线, 1: HIVE)
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * 获取：目标类型(0: 总线, 1: HIVE)
   */
  public String getType() {
    return type;
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
   * 设置：状态(0: 启用, 1: 停用)
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * 获取：状态(0: 启用, 1: 停用)
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

  public Long getTargetId() {
    return targetId;
  }

  public void setTargetId(Long targetId) {
    this.targetId = targetId;
  }
}
