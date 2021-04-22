package com.yunli.bigdata.dsep.service.common.dto.statistics;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author wei
 */
public class DataResourceClassification implements Serializable {
  @ApiModelProperty("数据表所属部门")
  private String classification;

  @ApiModelProperty("资源数量")
  private Long count;

  @ApiModelProperty("资源数量占比")
  private Double ratio;

  public DataResourceClassification() {
  }

  public DataResourceClassification(String classification, Long count, Double ratio) {
    this.classification = classification;
    this.count = count;
    this.ratio = ratio;
  }

  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public Double getRatio() {
    return ratio;
  }

  public void setRatio(Double ratio) {
    this.ratio = ratio;
  }
}
