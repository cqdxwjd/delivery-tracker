package com.yunli.bigdata.dsep.service.orm.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author guozhijun
 * @description 数据源表结构扩展属性信息表
 * @date 2019/12/10
 */
@Entity
@Table(name = "data_resource_extend_values")
@EntityListeners(AuditingEntityListener.class)
public class DataResourceExtendValues {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  //扩展属性表主键ID
//    @Column(name = "extend_id")
//    private Long extendid;

  @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
  @JoinColumn(name = "extend_id")
  @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
  private DataResourceExtendProperties property;

  //扩展属性对应的值
  @Column(name = "data_info")
  private String datainfo;

  //状态 （0-(初始状态), 2-已发布, 3-已删除)
  @Column(name = "status")
  private int status;

  //创建时间
  @Column(name = "create_time")
  @CreatedDate
  private Date createTime;

  //更新时间
  @Column(name = "update_time")
  @LastModifiedDate
  private Date updateTime;

  @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
  @JoinColumn(name = "resource_id")
  private DataResource resource;

  public DataResourceExtendValues(DataResource dataResource, DataResourceExtendProperties property, String datainfo,
      int status) {
    this.resource = dataResource;
    this.property = property;
    this.datainfo = datainfo;
    this.status = status;
  }

  public DataResourceExtendValues(DataResource resource, DataResourceExtendProperties property, String datainfo,
      int status, Date createTime, Date updateTime) {
    this.resource = resource;
    this.property = property;
    this.datainfo = datainfo;
    this.status = status;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  public DataResourceExtendValues() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DataResource getResource() {
    return resource;
  }

  public void setResource(DataResource resource) {
    this.resource = resource;
  }

  public DataResourceExtendProperties getProperty() {
    return property;
  }

  public void setProperty(DataResourceExtendProperties property) {
    this.property = property;
  }

  public String getDatainfo() {
    return datainfo;
  }

  public void setDatainfo(String datainfo) {
    this.datainfo = datainfo;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataResourceExtendValues that = (DataResourceExtendValues) o;
    return Objects.equals(property, that.property) &&
        Objects.equals(resource, that.resource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(property, resource);
  }
}
