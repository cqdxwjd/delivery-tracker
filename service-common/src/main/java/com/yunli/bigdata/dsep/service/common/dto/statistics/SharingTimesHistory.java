package com.yunli.bigdata.dsep.service.common.dto.statistics;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wei
 */
public class SharingTimesHistory implements Serializable {
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty("时间")
  private Date time;

  @ApiModelProperty("共享次数")
  private Long times;

  public SharingTimesHistory() {
  }

  public SharingTimesHistory(Date time, Long times) {
    this.time = time;
    this.times = times;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Long getTimes() {
    return times;
  }

  public void setTimes(Long times) {
    this.times = times;
  }
}
