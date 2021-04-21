package com.yunli.bigdata.dsep.service.orm.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description: 作业主实体类
 * @Author: jiangxunyu
 * @CreateDate: 2019/7/11 14:12
 */
@Entity
@Table(name = "job_info", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@EntityListeners(AuditingEntityListener.class)
public class JobInfo implements Serializable {


  /**
   * 作业ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 作业名称
   */
  @Column
  private String name;

  /**
   * 作业类型
   */
  @Column
  private String type;

  @Column
  private String resourceType;

  /**
   * 作业描述
   */
  @Column
  private String description;

  /**
   * 责任人
   */
  @Column
  private String owner;

  /**
   * 作业状态，默认0 (0: 启动, 1: 停止, 9: 逻辑删除)
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

  /**
   * 作业详情信息
   */
  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobInfo", optional = false)
  @PrimaryKeyJoinColumn
  private JobDetail jobDetail = new JobDetail();

  /**
   * 作业依赖关联集合
   */
  @JsonIgnore
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "job_relation",
      joinColumns = @JoinColumn(name = "job_id"),
      inverseJoinColumns = @JoinColumn(name = "depend_job_id"))
  private Set<JobInfo> jobRelations = new HashSet<>();

  public JobInfo() {
  }

  public JobInfo(String name, String description, String owner, Integer status) {
    this.name = name;
    this.description = description;
    this.owner = owner;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
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

  public JobDetail getJobDetail() {
    return jobDetail;
  }

  public void setJobDetail(JobDetail jobDetail) {
    this.jobDetail = jobDetail;
  }

  public Set<JobInfo> getJobRelations() {
    return jobRelations;
  }

  public void setJobRelations(Set<JobInfo> jobRelations) {
    this.jobRelations = jobRelations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobInfo jobInfo = (JobInfo) o;
    return name.equals(jobInfo.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "JobInfo{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", status=" + status +
        '}';
  }
}
