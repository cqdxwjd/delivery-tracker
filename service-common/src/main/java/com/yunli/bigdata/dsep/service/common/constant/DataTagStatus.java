package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @Description: 数据标签状态枚举类
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/24 15:19
 */
public enum DataTagStatus {

  /**
   *
   */
  UN_PUBLISHED("未发布", 0),
  PUBLISH_APPROVAL("发布审批中", 1),
  CHANGE_APPROVAL("变更审批中", 2),
  OFFLINE_APPROVAL("下架审批中", 3),
  PUBLISHED("已发布", 4);

  private String name;

  private Integer value;

  DataTagStatus(String name, Integer value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Integer getValue() {
    return value;
  }

  public static DataTagStatus valueOf(Integer value) {
    for (DataTagStatus dataTagStatus : DataTagStatus.values()) {
      if (dataTagStatus.getValue().equals(value)) {
        return dataTagStatus;
      }
    }
    throw new RuntimeException(String.format("no DataTagStatus value of %s", value));
  }
}
