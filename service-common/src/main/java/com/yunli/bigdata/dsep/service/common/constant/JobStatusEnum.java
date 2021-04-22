package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @Description: 作业状态枚举常量类
 * @Author: jiangxunyu
 * @CreateDate: 2019/7/15 14:25
 */
public enum JobStatusEnum {

  /**
   *
   */
  START(0, "运行中"),
  STOP(1, "暂停中"),
  FINISH(2, "已完成"),
  DELETE(9, "已删除");

  private Integer value;

  private String desc;

  JobStatusEnum(Integer value, String desc) {
    this.value = value;
    this.desc = desc;
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

  public static boolean contains(Integer value) {
    for (JobStatusEnum jobStatus : JobStatusEnum.values()) {
      if (jobStatus.value.equals(value)) {
        return true;
      }
    }
    return false;
  }

  public static Integer getValue(String desc) {
    for (JobStatusEnum jobStatus : JobStatusEnum.values()) {
      if (jobStatus.desc.equals(desc)) {
        return jobStatus.value;
      }
    }
    return -1;
  }

  public static String getValues() {
    StringBuilder builder = new StringBuilder();
    for (JobStatusEnum jobStatus : JobStatusEnum.values()) {
      builder.append(jobStatus.value);
      builder.append(",");
    }
    return builder.substring(0, builder.length() - 1);
  }

  public static String getDescs() {
    StringBuilder builder = new StringBuilder();
    for (JobStatusEnum jobStatus : JobStatusEnum.values()) {
      builder.append(jobStatus.getDesc());
      builder.append(",");
    }
    return builder.substring(0, builder.length() - 1);
  }
}
