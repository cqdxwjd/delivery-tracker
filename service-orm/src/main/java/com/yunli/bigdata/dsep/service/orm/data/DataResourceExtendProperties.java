package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guozhijun
 * @description 数据源表结构扩展属性表
 * @date 2019/12/10
 */
@Entity
@Table(name = "data_resource_extend_properties")
@EntityListeners(AuditingEntityListener.class)
public class DataResourceExtendProperties {

  /**主键,唯一标识*/
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** 扩展属性名称（英文） */
  @Column(name = "name_en", length = 64)
  private String nameEn;

  /** 扩展属性名称（中文） */
  @Column(name = "name_cn", length = 128)
  private String nameCn;

  /**属性声明分组编码值*/
  @Column(name = "group_code", length = 20)
  private String groupCode;

  /**属性描述*/
  @Column(name = "description")
  private String description;

  /**状态 （0-(初始状态), 2-已发布, 3-已删除)*/
  @Column(name = "status")
  private int status;

  /**创建时间*/
  @Column(name = "create_time")
  @CreatedDate
  private Date createTime;

  /**更新时间*/
  @Column(name = "update_time")
  @LastModifiedDate
  private Date updateTime;

  @OneToMany(mappedBy = "property", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<DataResourceExtendEnums> enums = new ArrayList<>();

  public DataResourceExtendProperties() {

  }

  public DataResourceExtendProperties(String nameCn, String description) {
    this.nameCn = nameCn;
    this.description = description;
    this.status = 2;
  }

  public DataResourceExtendProperties(String nameCn, String groupCode, String description) {
    this.nameCn = nameCn;
    this.description = description;
    this.status = 2;
    this.groupCode = groupCode;
  }

  public DataResourceExtendProperties(Long id, String nameEn, String groupCode, Date createTime, Date updateTime
      , List<DataResourceExtendEnums> enums) {
    this.id = id;
    this.nameEn = nameEn;
    this.groupCode = groupCode;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.enums = enums;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
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

  public String getGroupCode() {
    return groupCode;
  }

  public void setGroupCode(String groupCode) {
    this.groupCode = groupCode;
  }

  public List<DataResourceExtendEnums> getEnums() {
    return enums;
  }

  public void setEnums(List<DataResourceExtendEnums> enums) {
    this.enums = enums;
  }
}
