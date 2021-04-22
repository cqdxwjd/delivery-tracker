package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;

/**
 * @author wei
 */
public class FilterConditions implements Serializable {
  String column;

  String value;

  public FilterConditions() {
  }

  public FilterConditions(String column, String value) {
    this.column = column;
    this.value = value;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
