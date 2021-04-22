package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @Description: 任务运行状态枚举常量类
 * @Author: jiangxunyu
 * @CreateDate: 2019/7/15 14:31
 */
public enum TaskStatusEnum {
  /**
   * 待运行
   */
  CREATED(0, "待运行"),
//  READY(1, "就绪"),
  RUNNING(2, "运行中"),
  SUSPEND(3, "暂停中"),
  SUCCESS(4, "运行成功"),
  FAILED(5, "运行失败");

  private Integer value;

  private String desc;

  TaskStatusEnum(Integer value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public static TaskStatusEnum byValue(Integer value) {
    for (TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()) {
      if (taskStatusEnum.getValue().equals(value)) {
        return taskStatusEnum;
      }
    }
    throw new IllegalArgumentException(String.format("this value [%d] not exists.", value));
  }

  public static TaskStatusEnum byDesc(String desc) {
    for (TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()) {
      if (taskStatusEnum.getDesc().equals(desc)) {
        return taskStatusEnum;
      }
    }
    throw new IllegalArgumentException(String.format("this value [%s] not exists.", desc));
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
