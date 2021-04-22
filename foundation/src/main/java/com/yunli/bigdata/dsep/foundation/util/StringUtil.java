package com.yunli.bigdata.dsep.foundation.util;

/**
 * @author : zhengyangyong
 */
public class StringUtil {
  public static boolean contains(String source, String[] targets) {
    for (String target : targets) {
      if (source.contains(target)) {
        return true;
      }
    }
    return false;
  }

  public static String formatSqlLike(String condition) {
    String formattedCondition = condition;
    if (formattedCondition.contains("/")) {
      formattedCondition = formattedCondition.replace("/", "//");
    }
    if (formattedCondition.contains("_")) {
      formattedCondition = formattedCondition.replace("_", "/_");
    }
    if (formattedCondition.contains("%")) {
      formattedCondition = formattedCondition.replace("%", "/%");
    }
    return "%" + formattedCondition + "%";
  }

  public static String join(String delimiter, Iterable<Object> iterable) {
    if (delimiter != null && iterable != null) {
      StringBuilder builder = new StringBuilder();
      for (Object o : iterable) {
        builder.append(o);
        builder.append(delimiter);
      }
      return builder.substring(0, builder.length() - delimiter.length());
    } else {
      return "";
    }
  }

}
