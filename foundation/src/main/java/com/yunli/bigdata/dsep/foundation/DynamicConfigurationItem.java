package com.yunli.bigdata.dsep.foundation;

/**
 * @author : zhengyangyong
 */
public class DynamicConfigurationItem {
  private String key;

  private String value;

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public DynamicConfigurationItem() {
  }

  public DynamicConfigurationItem(String key, String value) {
    this.key = key;
    this.value = value;
  }
}
