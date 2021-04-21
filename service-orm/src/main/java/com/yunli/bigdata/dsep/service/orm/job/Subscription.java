package com.yunli.bigdata.dsep.service.orm.job;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhangws
 */
@Entity
@Table(name = "iot_subscription")
@EntityListeners(AuditingEntityListener.class)
public class Subscription {

  /**
   * ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 订阅目标（AdapterId和AccessoryId）
   */
  @Column
  private String target;

  /**
   * 状态（0：正常；8：失效；9：删除）
   */
  @Column
  private Integer status;

  /**
   * 创建时间
   */
  @LastModifiedDate
  @Column
  private Date updateTime;


  public Subscription() {
  }

  public Subscription(String target) {
    this.target = target;
    this.status = 0;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
