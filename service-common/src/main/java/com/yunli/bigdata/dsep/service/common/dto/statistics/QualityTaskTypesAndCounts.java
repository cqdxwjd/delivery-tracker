package com.yunli.bigdata.dsep.service.common.dto.statistics;

/**
 * @author wei
 */
public class QualityTaskTypesAndCounts {
  private String name;

  private Long count;

  public QualityTaskTypesAndCounts() {
  }

  public QualityTaskTypesAndCounts(String name, Long count) {
    this.name = name;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }
}
