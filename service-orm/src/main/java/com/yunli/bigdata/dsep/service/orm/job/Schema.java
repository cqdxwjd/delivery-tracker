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
@Table(name = "iot_schema")
@EntityListeners(AuditingEntityListener.class)
public class Schema {

  /**
   * ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 设备(数据源)类型
   */
  @Column
  private String deviceType;

  /**
   * 设备的型号
   */
  @Column
  private String deviceModel;

  /**
   * 字段描述
   */
  @Column
  private String field;

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

  public Schema() {
  }

  public Schema(String deviceType,
      String deviceModel,
      String field) {
    this.deviceType = deviceType;
    this.deviceModel = deviceModel;
    this.field = field;
    this.status = 0;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
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
