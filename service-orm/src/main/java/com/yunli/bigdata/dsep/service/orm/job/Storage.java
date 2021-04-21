package com.yunli.bigdata.dsep.service.orm.job;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhangws
 */
@Entity
@Table(name = "iot_storage", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@EntityListeners(AuditingEntityListener.class)
public class Storage {

  /**
   * ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 唯一标识，这个会作为自动创建的数据表的英文名，必填，必须符合表名要求
   */
  @Column
  private String name;

  /**
   * deviceType过滤
   */
  @Column
  private String deviceType;

  /**
   * deviceModel过滤
   */
  @Column
  private String deviceModel;

  /**
   * 备注
   */
  @Column
  private String note;

  /**
   * 状态（0：新建；1：运行中；2：失效；9：删除）
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

  public Storage() {
  }

  public Storage(String name,
      String deviceType,
      String deviceModel,
      String note) {
    this.name = name;
    this.deviceType = deviceType;
    this.deviceModel = deviceModel;
    this.note = note;
    this.status = 0;
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

  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  public String getDeviceModel() {
    return deviceModel;
  }

  public void setDeviceModel(String deviceModel) {
    this.deviceModel = deviceModel;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
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
}
