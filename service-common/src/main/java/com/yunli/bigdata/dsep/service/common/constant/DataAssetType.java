package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @author zhangws
 */
public enum DataAssetType {

  /**
   *
   */
  TABLE("data", "数据表"),
  DOCUMENT("document", "文件夹"),
  TOPIC("topic", "实时数据信道");

  private String code;

  private String name;

  DataAssetType(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public static String getNames() {
    StringBuilder builder = new StringBuilder();
    for (DataAssetType type : DataAssetType.values()) {
      builder.append(type.name);
      builder.append(",");
    }
    return builder.substring(0, builder.length() - 1);
  }

  public static boolean contains(String code) {
    for (DataAssetType type : DataAssetType.values()) {
      if (type.getCode().equals(code)) {
        return true;
      }
    }
    return false;
  }
}
