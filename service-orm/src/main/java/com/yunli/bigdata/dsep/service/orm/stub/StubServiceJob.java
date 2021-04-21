package com.yunli.bigdata.dsep.service.orm.stub;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 实时作业信息表
 *
 * @author david
 * @email fudawei@yunlizhihui.com
 * @date 2020-06-11 11:40:26
 */
@Entity
@Table(name = "stub_service_job")
@EntityListeners(AuditingEntityListener.class)
public class StubServiceJob implements Serializable {
  private static final long serialVersionUID = 1L;

  //作业ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //TOPIC编码
  @Column(name = "topic_id")
  private Long topicId;

  //作业名称
  @Column(name = "name")
  private String name;

  //作业在stub上的编码名称，系统默认生成，用UUID来标示
  @Column(name = "stub_code")
  private String stubCode;

  //实例数量
  @Column(name = "instances")
  private Long instances;

  //开始时间
  @CreatedDate
  @Column(name = "start_time")
  private Date startTime;

  //结束时间
  @Column(name = "end_time")
  private Date endTime;

  //文件路径
  @Column(name = "file_id")
  private Long fileId;

  //配置信息
  @Column(name = "config")
  private String config;

  //作业类型(0: 实时入库, 1: 实时质检)
  @Column(name = "type")
  private String type;

  //作业描述
  @Column(name = "description")
  private String description;

  //责任人
  @Column(name = "owner")
  private String owner;

  //作业状态(0: 启用, 1: 停用, 2: 已完成)
  @Column(name = "status")
  private Integer status;

  //创建时间
  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  //更新时间
  @UpdateTimestamp
  @Column(name = "update_time")
  private Date updateTime;


  /**
   * 设置：作业ID
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取：作业ID
   */
  public Long getId() {
    return id;
  }

  /**
   * 设置：TOPIC编码
   */
  public void setTopicId(Long topicId) {
    this.topicId = topicId;
  }

  /**
   * 获取：TOPIC编码
   */
  public Long getTopicId() {
    return topicId;
  }

  /**
   * 设置：作业名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取：作业名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置：实例数量
   */
  public void setInstances(Long instances) {
    this.instances = instances;
  }

  /**
   * 获取：实例数量
   */
  public Long getInstances() {
    return instances;
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

  public Long getFileId() {
    return fileId;
  }

  public void setFileId(Long fileId) {
    this.fileId = fileId;
  }

  /**
   * 设置：配置信息
   */
  public void setConfig(String config) {
    this.config = config;
  }

  /**
   * 获取：配置信息
   */
  public String getConfig() {
    return config;
  }

  /**
   * 设置：作业类型(0: 实时入库, 1: 实时质检)
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * 获取：作业类型(0: 实时入库, 1: 实时质检)
   */
  public String getType() {
    return type;
  }

  /**
   * 设置：作业描述
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 获取：作业描述
   */
  public String getDescription() {
    return description;
  }

  /**
   * 设置：责任人
   */
  public void setOwner(String owner) {
    this.owner = owner;
  }

  /**
   * 获取：责任人
   */
  public String getOwner() {
    return owner;
  }

  /**
   * 设置：作业状态(0: 启用, 1: 停用, 2: 已完成, 9: 逻辑删除)
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * 获取：作业状态(0: 启用, 1: 停用, 2: 已完成, 9: 逻辑删除)
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

  public String getStubCode() {
    return stubCode;
  }

  public void setStubCode(String stubCode) {
    this.stubCode = stubCode;
  }

  public StubServiceJob() {
  }

  public StubServiceJob(Long topicId, String name, Long instances, Long fileId,
      String config, String type, String description, String owner, String stubCode) {
    this.topicId = topicId;
    this.name = name;
    this.instances = instances;
    this.fileId = fileId;
    this.config = config;
    this.type = type;
    this.description = description;
    this.owner = owner;
    this.stubCode = stubCode;
  }
}
