package com.yunli.bigdata.dsep.service.orm.job;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhangws 2019/07/05
 */
@Entity
@Table(name = "job_detail", uniqueConstraints = @UniqueConstraint(columnNames = {"job_id"}))
public class JobDetail implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "job_id")
  private JobInfo jobInfo;

  // 作业模板
  @Column
  private String template;

  @Column
  private String source;

  @Column
  private String target;

  // 执行优化参数
  @Column
  private String optimizerParams;

  // 作业生效开始日期
  @Column
  private Date startTime;

  // 作业生效结束日期
  @Column
  private Date endTime;

  // 作业调度周期
  @Column
  private String cycle;

  // 调度详情
  @Column
  private String scheduleInfo;

  @Column
  private String cron;

  public JobDetail() {
  }

  public JobDetail(String template, String optimizerParams, Date startTime, Date endTime, String scheduleInfo,
      String cron) {
    this.template = template;
    this.optimizerParams = optimizerParams;
    this.startTime = startTime;
    this.endTime = endTime;
    this.scheduleInfo = scheduleInfo;
    this.cron = cron;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
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

  public String getOptimizerParams() {
    return optimizerParams;
  }

  public void setOptimizerParams(String optimizerParams) {
    this.optimizerParams = optimizerParams;
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

  public String getCycle() {
    return cycle;
  }

  public void setCycle(String cycle) {
    this.cycle = cycle;
  }

  public String getScheduleInfo() {
    return scheduleInfo;
  }

  public void setScheduleInfo(String scheduleInfo) {
    this.scheduleInfo = scheduleInfo;
  }

  public JobInfo getJobInfo() {
    return jobInfo;
  }

  public void setJobInfo(JobInfo jobInfo) {
    this.jobInfo = jobInfo;
  }

  public String getCron() {
    return cron;
  }

  public void setCron(String cron) {
    this.cron = cron;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobDetail jobDetail = (JobDetail) o;
    return jobInfo.equals(jobDetail.jobInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobInfo);
  }
}
