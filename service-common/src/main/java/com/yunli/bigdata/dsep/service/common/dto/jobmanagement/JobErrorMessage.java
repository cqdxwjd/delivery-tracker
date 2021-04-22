package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

/**
 * @author wei
 */
public class JobErrorMessage {
  private String errorWhenRead;

  private String errorWhenModify;

  public JobErrorMessage() {
  }

  public JobErrorMessage(String errorWhenRead, String errorWhenModify) {
    this.errorWhenRead = errorWhenRead;
    this.errorWhenModify = errorWhenModify;
  }

  public String getErrorWhenRead() {
    return errorWhenRead;
  }

  public void setErrorWhenRead(String errorWhenRead) {
    this.errorWhenRead = errorWhenRead;
  }

  public String getErrorWhenModify() {
    return errorWhenModify;
  }

  public void setErrorWhenModify(String errorWhenModify) {
    this.errorWhenModify = errorWhenModify;
  }
}
