package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.List;
import java.util.Map;

/**
 * @author wei
 */
public class ScreenTendency extends ScreenStatistics {
  private List<String> dates;

  private Long length;

  private Map<String, List<Long>> values;

  public List<String> getDates() {
    return dates;
  }

  public void setDates(List<String> dates) {
    this.dates = dates;
  }

  public Long getLength() {
    return length;
  }

  public void setLength(Long length) {
    this.length = length;
  }

  public Map<String, List<Long>> getValues() {
    return values;
  }

  public void setValues(Map<String, List<Long>> values) {
    this.values = values;
  }
}
