package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @author wei
 */
public enum ResourceStatus {
  /**
   * 未发布
   */
  Unpublished("未发布", 0),
  /**
   * 发布审核中
   */
  PublishAuditing("发布审核中", 1),
  /**
   * 已发布
   */
  Published("已发布", 2),
  /**
   * 变更审核中
   */
  ChangeAuditing("变更审核中", 3),
  /**
   * 下架审核中
   */
  OffShelvesAuditing("下架审核中", 4),
  /**
   * 关联目录审核中
   */
  AssociatedCatalogAuditing("关联目录审核中", 5),
  /**
   * 加载数据审核中
   */
  LoadDataAuditing("加载数据审核中", 6),

  ;

  private String name;

  private int value;

  ResourceStatus(String name, int value) {
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
    for (ResourceStatus status : ResourceStatus.values()) {
      if (status.value == value) {
        return true;
      }
    }
    return false;
  }

  public static ResourceStatus valueOf(int value) throws RuntimeException {
    for (ResourceStatus type : values()) {
      if (type.value == value) {
        return type;
      }
    }
    throw new RuntimeException(String.format("no ResourceStatus value of %s", value));
  }
}
