package com.yunli.bigdata.dsep.service.common.dto.resource;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 添加数据存储信息参数对象
 *
 * @author wei
 */
@ApiModel(description = "添加数据存储信息参数对象")
public class AddDataStorageRequestDto implements Serializable {

  private String storageName;

  private String storageType;

  private String connection;

  private String description;

  private Integer scope;

  public AddDataStorageRequestDto() {
  }

  public AddDataStorageRequestDto(String storageName, String storageType, String connection, String description,
      Integer scope) {
    this.storageName = storageName;
    this.storageType = storageType;
    this.connection = connection;
    this.description = description;
    this.scope = scope;
  }


  /**
   * 数据存储信息名称
   *
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
   *
   * @return storageType
   **/
  @ApiModelProperty("数据存储信息类型 0:MaxCompute 1:Mysql")
  public String getStorageType() {
    return storageType;
  }

  public void setStorageType(String storageType) {
    this.storageType = storageType;
  }


  /**
   * 数据存储信息连接信息
   *
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
   *
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
