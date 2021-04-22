package com.yunli.bigdata.dsep.foundation;

/**
 * @author : zhengyangyong
 */
public class HealthInformation {
  private String status;

  private String detail;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public HealthInformation() {
  }

  public HealthInformation(String status, String detail) {
    this.status = status;
    this.detail = detail;
  }
}
