package com.yunli.bigdata.dsep.service.orm.stub;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 实时作业参数表
 *
 * @author david
 * @email fudawei@yunlizhihui.com
 * @date 2020-06-11 12:15:41
 */
@Entity
@Table(name = "stub_service_job_parameter")
@EntityListeners(AuditingEntityListener.class)
public class StubServiceJobParameter implements Serializable {
  private static final long serialVersionUID = 1L;

  //主键ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //作业ID
  @Column(name = "job_id")
  private Long jobId;

  //参数键
  @Column(name = "param_key")
  private String paramKey;

  //参数值
  @Column(name = "param_value")
  private String paramValue;

  public StubServiceJobParameter() {
  }

  public StubServiceJobParameter(Long jobId, String paramKey, String paramValue) {
    this.jobId = jobId;
    this.paramKey = paramKey;
    this.paramValue = paramValue;
  }

  /**
   * 设置：主键ID
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取：主键ID
   */
  public Long getId() {
    return id;
  }

  /**
   * 设置：作业ID
   */
  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  /**
   * 获取：作业ID
   */
  public Long getJobId() {
    return jobId;
  }

  /**
   * 设置：参数键
   */
  public void setParamKey(String paramKey) {
    this.paramKey = paramKey;
  }

  /**
   * 获取：参数键
   */
  public String getParamKey() {
    return paramKey;
  }

  /**
   * 设置：参数值
   */
  public void setParamValue(String paramValue) {
    this.paramValue = paramValue;
  }

  /**
   * 获取：参数值
   */
  public String getParamValue() {
    return paramValue;
  }
}
