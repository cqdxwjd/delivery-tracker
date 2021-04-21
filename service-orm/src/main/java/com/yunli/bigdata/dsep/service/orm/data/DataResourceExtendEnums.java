package com.yunli.bigdata.dsep.service.orm.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author guozhijun
 * @description 数据表扩展属性枚举
 * @date 2020/2/6
 */
@Entity
@Table(name = "data_resource_extend_enums")
@EntityListeners(AuditingEntityListener.class)
public class DataResourceExtendEnums {

  /** 主键,唯一标识 */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** 扩展属性声明ID */
  @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
  @JoinColumn(name = "property_id")
  @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
  private DataResourceExtendProperties property;

  /** 扩展属性名称（英文） */
  @Column(name = "name_en", length = 64)
  private String nameEn;

  /** 扩展属性名称（中文） */
  @Column(name = "name_cn", length = 128)
  private String nameCn;

  /** 扩展属性枚举描述 */
  @Column(name = "description", length = 128)
  private String description;

  /** 创建时间 */
  @Column(name = "create_time")
  @CreatedDate
  private Date createTime;

  /** 更新时间 */
  @Column(name = "update_time")
  @LastModifiedDate
  private Date updateTime;

  public DataResourceExtendEnums() {
  }

  public DataResourceExtendEnums(DataResourceExtendProperties property, String nameCn, String description) {
    this.property = property;
    this.nameCn = nameCn;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DataResourceExtendProperties getProperty() {
    return property;
  }

  public void setProperty(DataResourceExtendProperties property) {
    this.property = property;
  }

  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }

  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
