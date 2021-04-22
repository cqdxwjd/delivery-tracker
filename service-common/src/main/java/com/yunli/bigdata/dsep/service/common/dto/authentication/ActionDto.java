package com.yunli.bigdata.dsep.service.common.dto.authentication;

import java.io.Serializable;

/**
 * @author wei
 */
public class ActionDto implements Serializable {
  private String code;

  private String name;

  private Boolean value = false;

  public ActionDto() {
  }

  public ActionDto(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public ActionDto(String code, String name, Boolean value) {
    this.code = code;
    this.name = name;
    this.value = value;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getValue() {
    return value;
  }

  public void setValue(Boolean value) {
    this.value = value;
  }
}
