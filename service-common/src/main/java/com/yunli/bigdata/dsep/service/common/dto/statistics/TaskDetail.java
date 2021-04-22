package com.yunli.bigdata.dsep.service.common.dto.statistics;

/**
 * 任务运行明细
 */
public class TaskDetail {

  /**
   * 任务总数
   */
  private Long total = 0L;

  /**
   * 未运行
   */
  private Long finalOperation = 0L;

  /**
   * 运行中
   */
  private Long inOperation = 0L;

  /**
   * 运行中
   */
  private Long runSuccessfully = 0L;

  /**
   * 运行失败
   */
  private Long runFailed = 0L;

  public TaskDetail() {
  }

  public TaskDetail( Long inOperation, Long runSuccessfully, Long runFailed) {
    this.inOperation = inOperation;
    this.runSuccessfully = runSuccessfully;
    this.runFailed = runFailed;
    this.total = inOperation + runSuccessfully + runFailed;
  }

  public TaskDetail(Long finalOperation, Long inOperation, Long runSuccessfully, Long runFailed) {
    this.total = finalOperation + inOperation + runSuccessfully + runFailed;
    this.finalOperation = finalOperation;
    this.inOperation = inOperation;
    this.runSuccessfully = runSuccessfully;
    this.runFailed = runFailed;
  }

  public TaskDetail(Long inOperation, Long runSuccessfully) {
    this.total = inOperation + runSuccessfully;
    this.inOperation = inOperation;
    this.runSuccessfully = runSuccessfully;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public Long getFinalOperation() {
    return finalOperation;
  }

  public void setFinalOperation(Long finalOperation) {
    this.finalOperation = finalOperation;
  }

  public Long getInOperation() {
    return inOperation;
  }

  public void setInOperation(Long inOperation) {
    this.inOperation = inOperation;
  }

  public Long getRunSuccessfully() {
    return runSuccessfully;
  }

  public void setRunSuccessfully(Long runSuccessfully) {
    this.runSuccessfully = runSuccessfully;
  }

  public Long getRunFailed() {
    return runFailed;
  }

  public void setRunFailed(Long runFailed) {
    this.runFailed = runFailed;
  }
}
