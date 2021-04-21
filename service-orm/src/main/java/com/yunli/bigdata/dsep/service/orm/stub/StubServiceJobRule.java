package com.yunli.bigdata.dsep.service.orm.stub;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 实时作业规则表
 *
 * @author david
 * @email fudawei@yunlizhihui.com
 * @date 2020-06-11 11:40:26
 */
@Entity
@Table(name = "stub_service_job_rule")
@EntityListeners(AuditingEntityListener.class)
public class StubServiceJobRule implements Serializable {
  private static final long serialVersionUID = 1L;

  //规则ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //job编码
  @Column(name = "job_id")
  private Long jobId;

  //分区信息
  @Column(name = "expression")
  private String expression;

  //描述
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

  public StubServiceJobRule() {
  }

  public StubServiceJobRule(Long jobId, String expression, String description) {
    this.jobId = jobId;
    this.expression = expression;
    this.description = description;
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

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }
}
