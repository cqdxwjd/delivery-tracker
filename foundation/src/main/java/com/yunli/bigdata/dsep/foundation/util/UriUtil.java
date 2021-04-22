package com.yunli.bigdata.dsep.foundation.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author : zhengyangyong
 */
public class UriUtil {
  public static boolean isValidUri(String uriStr) {
    try {
      new URI(uriStr);
      return true;
    } catch (URISyntaxException e) {
      return false;
    }
  }

  public static String build(String... parts) {
    if (parts.length == 1) {
      return parts[0];
    }
    StringBuilder uri = new StringBuilder(parts[0]);
    for (int i = 1; i < parts.length; i++) {
      if (parts[i - 1].endsWith("/")) {
        uri.append(parts[i].startsWith("/") ? parts[i].substring(1) : parts[i]);
      } else {
        uri.append(parts[i].startsWith("/") ? parts[i] : "/" + parts[i]);
      }
    }
    return uri.toString();
  }

  public static String buildPath(String... parts) {
    if (parts.length == 1) {
      return parts[0];
    }
    StringBuilder uri = new StringBuilder(parts[0]);
    for (int i = 1; i < parts.length; i++) {
      if (parts[i - 1].endsWith("/")) {
        uri.append(parts[i].startsWith("/") ? parts[i].substring(1) : parts[i]);
      } else {
        uri.append(parts[i].startsWith("/") ? parts[i] : "/" + parts[i]);
      }
    }
    return uri.toString();
  }
}
