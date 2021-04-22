package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @author wei
 */
public enum SubscribeStatus {
  /**
   * 未申请
   */
  Default("未申请", 0),
  /**
   * 审批中
   */
  Approving("审批中", 1),
  /**
   * 已授权
   */
  Subscribed("已授权", 2),

  ;

  private String name;

  private int value;

  SubscribeStatus(String name, int value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public static String getNames() {
    StringBuilder builder = new StringBuilder();
    for (SubscribeStatus status : SubscribeStatus.values()) {
      builder.append(status.name);
      builder.append(",");
    }
    return builder.substring(0, builder.length() - 1);
  }

  public static boolean contains(int value) {
    for (SubscribeStatus status : SubscribeStatus.values()) {
      if (status.value == value) {
        return true;
      }
    }
    return false;
  }

  public static SubscribeStatus valueOf(int value) throws RuntimeException {
    for (SubscribeStatus type : values()) {
      if (type.value == value) {
        return type;
      }
    }
    throw new RuntimeException(String.format("no ResourceStatus value of %s", value));
  }
}
