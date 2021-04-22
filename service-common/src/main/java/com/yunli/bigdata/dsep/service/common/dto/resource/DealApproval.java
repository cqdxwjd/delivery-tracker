package com.yunli.bigdata.dsep.service.common.dto.resource;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wei
 */
public class DealApproval {
  @ApiModelProperty("审批结果 (通过:1 未通过:2 撤回授权:3)")
  private Integer approvalResult;

  @ApiModelProperty("审批意见")
  private String reason;

  public DealApproval() {
  }

  public DealApproval(Integer approvalResult, String reason) {
    this.approvalResult = approvalResult;
    this.reason = reason;
  }

  public Integer getApprovalResult() {
    return approvalResult;
  }

  public void setApprovalResult(Integer approvalResult) {
    this.approvalResult = approvalResult;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}
