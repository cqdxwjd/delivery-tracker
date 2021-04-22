package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.io.Serializable;
import java.util.List;

/**
 * @author wei
 */
public class LineageInfo implements Serializable {
  private Long totalCount;

  private List<String> top10Names;

  public LineageInfo() {
  }

  public LineageInfo(Long totalCount, List<String> top10Names) {
    this.totalCount = totalCount;
    this.top10Names = top10Names;
  }

  public Long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  public List<String> getTop10Names() {
    return top10Names;
  }

  public void setTop10Names(List<String> top10Names) {
    this.top10Names = top10Names;
  }
}
