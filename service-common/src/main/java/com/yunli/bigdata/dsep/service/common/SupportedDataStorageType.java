package com.yunli.bigdata.dsep.service.common;

import java.util.HashMap;
import java.util.Map;


public class SupportedDataStorageType {
  public static final String ODPS = "odps";

  public static final String MYSQL = "mysql";

  public static final String HIVE = "hive";

  private final Map<String, String> types = new HashMap<>();

  private static class InnerClass {

  }

  private SupportedDataStorageType() {
    types.put(ODPS,
        "{\"accessId\": \"string\", \"accessKey\": \"string\", \"endPoint\": \"http://service.odps.aliyun.com/api\", \"projectName\": \"string\"}");
    types.put(HIVE,
        "{\"jdbcUrl\": \"jdbc:hive://localhost:10000\", \"userName\": \"root\", \"password\": \"12345\", \"db\": \"test\"}");
    types.put(MYSQL,
        "{\"jdbcUrl\": \"jdbc:mysql://localhost:3306\", \"userName\": \"root\", \"password\": \"12345\", \"db\": \"test\"}");
  }

  public String getTemplate(String type) {
    return types.getOrDefault(type, null);
  }
}
