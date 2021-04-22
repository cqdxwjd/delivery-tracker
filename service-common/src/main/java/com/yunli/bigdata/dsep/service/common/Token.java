package com.yunli.bigdata.dsep.service.common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wangpengfei
 * @date 2019-06-26
 */
public class Token {
  @JsonProperty("user")
  private String user;

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("organizationName")
  private String organizationName;

  @JsonProperty("expired_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date expiredDate;

  @JsonProperty("signature")
  private String signature;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public Date getExpiredDate() {
    return expiredDate;
  }

  public void setExpiredDate(Date expiredDate) {
    this.expiredDate = expiredDate;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  @Override
  public String toString() {
    return String.format("%s, %tF %tT", user, expiredDate, expiredDate);
  }
}
