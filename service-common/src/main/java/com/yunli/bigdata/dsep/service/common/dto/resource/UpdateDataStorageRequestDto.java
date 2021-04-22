package com.yunli.bigdata.dsep.service.common.dto.resource;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改数据存储信息参数对象
 * @author wei
 */
@ApiModel(description = "修改数据存储信息参数对象")
public class UpdateDataStorageRequestDto implements Serializable {

  private String storageName;

  private String description;

  private String connection;

  private Integer scope;

  public UpdateDataStorageRequestDto() {
  }

  public UpdateDataStorageRequestDto(String storageName, String description, String connection) {
    this.storageName = storageName;
    this.description = description;
    this.connection = connection;
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
   * 数据存储信息连接信息
   * @return connection
   **/
  @ApiModelProperty("数据存储信息连接信息(如果数据存储信息下存在数据表则不允许修改，只能新建数据表或者先删除数据表)")
  public String getConnection() {
    return connection;
  }

  public void setConnection(String connection) {
    this.connection = connection;
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
