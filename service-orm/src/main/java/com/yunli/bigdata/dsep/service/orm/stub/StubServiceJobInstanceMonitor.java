package com.yunli.bigdata.dsep.service.orm.stub;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 实时作业实例监控表
 *
 * @author david
 * @email fudawei@yunlizhihui.com
 * @date 2020-06-11 11:40:26
 */
@Entity
@Table(name = "stub_service_job_instance_monitor")
@EntityListeners(AuditingEntityListener.class)
public class StubServiceJobInstanceMonitor implements Serializable {
  private static final long serialVersionUID = 1L;

  //监控ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //实例编码
  @Column(name = "instance_id")
  private Long instanceId;

  //失败次数
  @Column(name = "fail_count")
  private Long failCount;

  //入流量
  @Column(name = "in_count")
  private BigDecimal inCount;

  //出流量
  @Column(name = "out_count")
  private BigDecimal outCount;

  //异常信息
  @Column(name = "error_message")
  private String errorMessage;

  //备注
  @Column(name = "description")
  private String description;

  //创建时间
  @Column(name = "create_time")
  @CreatedDate
  private Date createTime;

  //更新时间
  @Column(name = "update_time")
  @UpdateTimestamp
  private Date updateTime;


  /**
   * 设置：监控ID
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取：监控ID
   */
  public Long getId() {
    return id;
  }

  /**
   * 设置：实例编码
   */
  public void setInstanceId(Long instanceId) {
    this.instanceId = instanceId;
  }

  /**
   * 获取：实例编码
   */
  public Long getInstanceId() {
    return instanceId;
  }

  /**
   * 设置：失败次数
   */
  public void setFailCount(Long failCount) {
    this.failCount = failCount;
  }

  /**
   * 获取：失败次数
   */
  public Long getFailCount() {
    return failCount;
  }

  /**
   * 设置：入流量
   */
  public void setInCount(BigDecimal inCount) {
    this.inCount = inCount;
  }

  /**
   * 获取：入流量
   */
  public BigDecimal getInCount() {
    return inCount;
  }

  /**
   * 设置：出流量
   */
  public void setOutCount(BigDecimal outCount) {
    this.outCount = outCount;
  }

  /**
   * 获取：出流量
   */
  public BigDecimal getOutCount() {
    return outCount;
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

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
