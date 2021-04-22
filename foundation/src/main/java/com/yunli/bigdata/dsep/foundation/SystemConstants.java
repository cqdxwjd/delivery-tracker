package com.yunli.bigdata.dsep.foundation;

/**
 * @author : zhengyangyong
 */
public class SystemConstants {
  public static final String SERVICE_PATH_PREFIX = "x-";

  public static final String SERVICE_INVOCATION_ACL = "$service.invocation.acl";

  public static final String SERVICE_INVOCATION_ACL_ALL_ALLOW = "all";

  public static final String[] REGEX_META_STRING_LIST = new String[] {
      "\\", "^", "$", "*", "+", "?", "{", "}", "[", "]", "\\n", "\\s", "(", ")"
  };

  public static final String SERVICE_GOVERNANCE_RULE = "$service.governance.rule";
}
