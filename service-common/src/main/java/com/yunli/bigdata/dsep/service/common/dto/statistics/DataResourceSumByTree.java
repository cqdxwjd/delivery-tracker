package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wei
 */
public class DataResourceSumByTree implements Serializable {
  @ApiModelProperty("目录名称")
  private String tagName;

  @ApiModelProperty("资源数量")
  private Long resourceCount;

  @ApiModelProperty("资源数量占比")
  private Double ratio;

  public DataResourceSumByTree() {
  }

  public DataResourceSumByTree(String tagName, Long resourceCount, Double ratio) {
    this.tagName = tagName;
    this.resourceCount = resourceCount;
    this.ratio = ratio;
  }

  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  public Long getResourceCount() {
    return resourceCount;
  }

  public void setResourceCount(Long resourceCount) {
    this.resourceCount = resourceCount;
  }

  public Double getRatio() {
    return ratio;
  }

  public void setRatio(Double ratio) {
    this.ratio = ratio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataResourceSumByTree that = (DataResourceSumByTree) o;
    return Objects.equals(tagName, that.tagName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagName);
  }

  @Override
  public String toString() {
    return "DataResourceSumByTree{" +
        "tagName='" + tagName + '\'' +
        ", resourceCount=" + resourceCount +
        ", ratio=" + ratio +
        '}';
  }
}
