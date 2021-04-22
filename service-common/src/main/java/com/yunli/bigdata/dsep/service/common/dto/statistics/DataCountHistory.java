package com.yunli.bigdata.dsep.service.common.dto.statistics;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wei
 */
public class DataCountHistory implements Serializable {
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty("时间")
  private Date time;
  @ApiModelProperty("数据总量")
  private Double count;

  public DataCountHistory() {
  }

  public DataCountHistory(Date time, Double count) {
    this.time = time;
    this.count = count;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Double getCount() {
    return count;
  }

  public void setCount(Double count) {
    this.count = count;
  }
}
