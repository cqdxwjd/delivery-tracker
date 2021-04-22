package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @author wei
 */
public enum SharingType {
  /**
   * 有条件共享
   */
  Conditional("Conditional", 0),
  /**
   * 无条件共享
   */
  Unconditional("Unconditional", 1),
  /**
   * 不予共享
   */
  Refuse("Refuse", 2);

  private String name;

  private int value;

  SharingType(String name, int value) {
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

  public static boolean contains(int value) {
    for (SharingType status : SharingType.values()) {
      if (status.value == value) {
        return true;
      }
    }
    return false;
  }

  public static SharingType valueOf(int value) throws RuntimeException {
    for (SharingType type : values()) {
      if (type.value == value) {
        return type;
      }
    }
    throw new RuntimeException(String.format("no ResourceStatus value of %s", value));
  }
}
