package com.yunli.bigdata.dsep.service.orm.job;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Description: 作业参数表
 * @Author: jiangxunyu
 * @CreateDate: 2019/7/10 20:18
 */
@Entity
@Table(name = "job_parameter")
public class JobParameter implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long jobId;

  // 参数key
  @Column
  private String paramKey;

  // 参数value
  @Column
  private String paramValue;

  public JobParameter() {
  }

  public JobParameter(String paramKey, String paramValue) {
    this.paramKey = paramKey;
    this.paramValue = paramValue;
  }

  public JobParameter(Long jobId, String paramKey, String paramValue) {
    this.jobId = jobId;
    this.paramKey = paramKey;
    this.paramValue = paramValue;
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

  public String getParamKey() {
    return paramKey;
  }

  public void setParamKey(String paramKey) {
    this.paramKey = paramKey;
  }

  public String getParamValue() {
    return paramValue;
  }

  public void setParamValue(String paramValue) {
    this.paramValue = paramValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobParameter jobParameter = (JobParameter) o;
    return jobId.equals(jobParameter.jobId) &&
        paramKey.equals(jobParameter.paramKey) &&
        paramValue.equals(jobParameter.paramValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, paramKey, paramValue);
  }
}
