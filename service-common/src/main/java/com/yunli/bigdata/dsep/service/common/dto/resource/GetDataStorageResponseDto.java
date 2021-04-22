package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * GetDataStorageResponseDto
 * @author wei
 */

public class GetDataStorageResponseDto implements Serializable {

  private Long id;

  private String storageName;

  private String storageType;

  private String connection;

  private String description;

  private Integer scope;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  public GetDataStorageResponseDto() {
  }

  public GetDataStorageResponseDto(Long id, String storageName, String storageType, String connection,
      String description, Date createTime, Date updateTime, Integer scope) {
    this.id = id;
    this.storageName = storageName;
    this.storageType = storageType;
    this.connection = connection;
    this.description = description;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.scope = scope;
  }


  /**
   * 数据存储信息ID
   * @return id
   **/
  @ApiModelProperty("数据存储信息ID")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  /**
   * 数据存储信息名称
   * @return storageName
   **/
  @ApiModelProperty("数据存储信息名称")
  public String getStorageName() {
    return storageName;
  }

  public void setStorageName(String storageName) {
    this.storageName = storageName;
  }


  /**
   * 数据存储信息类型
   * @return storageType
   **/
  @ApiModelProperty("数据存储信息类型")
  public String getStorageType() {
    return storageType;
  }

  public void setStorageType(String storageType) {
    this.storageType = storageType;
  }


  /**
   * 数据存储信息连接信息
   * @return connection
   **/
  @ApiModelProperty("数据存储信息连接信息")
  public String getConnection() {
    return connection;
  }

  public void setConnection(String connection) {
    this.connection = connection;
  }


  /**
   * 数据存储信息描述
   * @return description
   **/
  @ApiModelProperty("数据存储信息描述")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  /**
   * 创建时间
   * @return createTime
   **/
  @ApiModelProperty("创建时间")
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  /**
   * 更新时间
   * @return updateTime
   **/
  @ApiModelProperty("更新时间")
  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * 数据存储信息作用域
   *
   * @return scope
   **/
  @ApiModelProperty(value = "数据存储信息作用域（0：内建底座；1：内建交互；2：用户自定义）", example = "2")
  public Integer getScope() {
    return scope;
  }

  public void setScope(Integer scope) {
    this.scope = scope;
  }
}
