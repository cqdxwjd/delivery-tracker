package com.yunli.bigdata.dsep.service.common.constant;

/**
 * 作业类型(0: 实时同步, 1: 实时数据治理，2：实时数据质检)
 * @author david
 */
public enum StubJobType {
  /**
   * 实时数据同步，即入仓
   */
  SYNCHRONIZATION("0", "实时同步"),
  /**
   * 入总线
   */
  MANAGEMENT("1", "实时数据治理"),
  /**
   * 入kafka
   */
  RULECOMPUTE("2", "实时数据质检");

  private String code;

  private String message;

  StubJobType(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public static boolean exists(String code) {
    for (StubJobType value : StubJobType.values()) {
      if (value.getCode().equals(code)) {
        return true;
      }
    }
    return false;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
