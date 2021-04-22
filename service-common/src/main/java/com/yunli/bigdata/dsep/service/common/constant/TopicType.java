package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @author david
 * @date 2020/7/8 3:16 下午
 */
public enum TopicType {
  /**
   * Kafka
   */
  Kafka("kafka"),
  /**
   * 事件总线
   */
  Event_bus("event-bus");

  private String name;

  TopicType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static boolean contains(String name) {
    for (TopicType status : TopicType.values()) {
      if (status.name.equals(name)) {
        return true;
      }
    }
    return false;
  }
}
