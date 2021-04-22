package com.yunli.bigdata.dsep.service.common.dto.statistics;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author wei
 */
public class SharingTimes implements Serializable {
  @ApiModelProperty("名称")
  private String name;

  @ApiModelProperty("共享次数")
  private Long times;

  public SharingTimes() {
  }

  public SharingTimes(String name, Long times) {
    this.name = name;
    this.times = times;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getTimes() {
    return times;
  }

  public void setTimes(Long times) {
    this.times = times;
  }
}
