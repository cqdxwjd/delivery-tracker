package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.constant.SubscribeStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangws
 */
@ApiModel(description = "资源目录高级检索响应")
public class QueryResourceResponse implements Serializable {
  @ApiModelProperty("资源类型（数据表:data 文件夹:document）")
  private String type;

  @ApiModelProperty("资源ID")
  private Long id;

  @ApiModelProperty("资源名称")
  private String name;

  @ApiModelProperty("资源描述")
  private String description;

  @ApiModelProperty("资源提供方")
  private String provider;

  @ApiModelProperty("更新时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  @ApiModelProperty("数据量/文件数")
  private Long count;

  @ApiModelProperty("共享次数")
  private Long sharingTimes;

  /**
   * 查询此资源的用户对此资源的访问权限
   **/
  @ApiModelProperty("查询此资源的用户对此资源的访问权限（未申请:0 审批中:1 已授权:2）")
  private Integer subscribeStatus = SubscribeStatus.Default.getValue();

  public QueryResourceResponse() {
  }

  public QueryResourceResponse(String type, Long id, String name, String description, String provider,
      Date updateTime, Long count, Long sharingTimes, Integer subscribeStatus) {
    this.type = type;
    this.id = id;
    this.name = name;
    this.description = description;
    this.provider = provider;
    this.updateTime = updateTime;
    this.count = count;
    this.sharingTimes = sharingTimes;
    this.subscribeStatus = subscribeStatus;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public Long getSharingTimes() {
    return sharingTimes;
  }

  public void setSharingTimes(Long sharingTimes) {
    this.sharingTimes = sharingTimes;
  }

  public Integer getSubscribeStatus() {
    return subscribeStatus;
  }

  public void setSubscribeStatus(Integer subscribeStatus) {
    this.subscribeStatus = subscribeStatus;
  }
}
