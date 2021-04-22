package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.util.List;
import java.util.Map;

/**
 * @author wei
 */
public class GetQualityStatisticsResponse {

  /**
   数据稽核任务总数
   */
  private Long totalTaskCount;

  /**
   按状态区分稽核任务数
   0 ： 等待执行
   1 ： 执行中
   2 ： 成功
   -1 ： 失败
   */
  private Map<Integer, Long> statusSeparatedTaskCounts;

  /**
   稽核类型的中文名
   */
  private List<QualityTaskTypesAndCounts> taskTypesAndCounts;

  /**
   数据稽核稽核记录数 (质量稽核数据量)
   */
  private Long totalRecordCount;

  public Long getTotalTaskCount() {
    return totalTaskCount;
  }

  public void setTotalTaskCount(Long totalTaskCount) {
    this.totalTaskCount = totalTaskCount;
  }

  public Map<Integer, Long> getStatusSeparatedTaskCounts() {
    return statusSeparatedTaskCounts;
  }

  public void setStatusSeparatedTaskCounts(Map<Integer, Long> statusSeparatedTaskCounts) {
    this.statusSeparatedTaskCounts = statusSeparatedTaskCounts;
  }

  public List<QualityTaskTypesAndCounts> getTaskTypesAndCounts() {
    return taskTypesAndCounts;
  }

  public void setTaskTypesAndCounts(
      List<QualityTaskTypesAndCounts> taskTypesAndCounts) {
    this.taskTypesAndCounts = taskTypesAndCounts;
  }

  public Long getTotalRecordCount() {
    return totalRecordCount;
  }

  public void setTotalRecordCount(Long totalRecordCount) {
    this.totalRecordCount = totalRecordCount;
  }

  public GetQualityStatisticsResponse() {
  }
}
