package com.yunli.bigdata.dsep.service.orm.job;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Description: 作业主实体类
 * @Author: jiangxunyu
 * @CreateDate: 2019/7/11 14:12
 */
@Entity
@Table(name = "file_job_attachment")
@EntityListeners(AuditingEntityListener.class)
public class FileJobAttachment implements Serializable {


  /**
   * 作业ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 作业ID
   */
  @Column
  private Long jobId;

  /**
   * 作业类型
   */
  @Column
  private String jobType;

  @Column
  private String filePath;

  public FileJobAttachment() {
  }

  public FileJobAttachment(Long jobId, String jobType, String filePath) {
    this.jobId = jobId;
    this.jobType = jobType;
    this.filePath = filePath;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileJobAttachment jobInfo = (FileJobAttachment) o;
    return jobId.equals(jobInfo.jobId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId);
  }

  @Override
  public String toString() {
    return "FileJobAttachement{" +
        "id=" + id +
        ", jobId=" + jobId +
        ", jobType='" + jobType + '\'' +
        ", filePath='" + filePath + '\'' +
        '}';
  }
}
