package com.yunli.bigdata.dsep.service.common.constant;

/**
 * 数据源作用范围
 *
 * @author zhangws
 */
public final class CommonConst {
  /**
   * 数据源作用范围：内置的主类型（例如ODPS、Hive）
   */
  public final static int DATA_SOURCE_SCOPE_BUILD_IN_MAIN = 0;

  /**
   * 资源存储作用范围：内置的交互类型（例如MySQL）
   */
  public final static int DATA_SOURCE_SCOPE_BUILD_IN_INTERACTIVE = 1;

  /**
   * 资源存储作用范围：内置的实时数据转储类型（例如MySQL）
   */
  public final static int DATA_SOURCE_SCOPE_BUILD_IN_REAL_DATA_DUMP = 2;

  /**
   * 资源存储作用范围：内置的文件转储类型（例如OSS）
   */
  public final static int DATA_SOURCE_SCOPE_BUILD_IN_FILE_STORAGE = 3;

  /**
   * 资源存储作用范围：用户自定义（没有特别限制）
   */
  public final static int DATA_SOURCE_SCOPE_USER_DEFINE = 9;

  public final static String RESOURCE_TYPE_TABLE = "table";

  public final static String RESOURCE_TYPE_FILE = "file";

  /**
   * API版本，目前固定v1
   */
  public final static String API_VERSION = "v1";

  public static final String EXCHANGE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

  public static final String EXCHANGE_TIMEZONE_FORMAT = "GMT+8";
}
