package com.yunli.bigdata.dsep.foundation.util;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author : zhengyangyong
 */
public class Base64Util {
  public static String decode(String content) {
    return new String(Base64.getDecoder().decode(content), Charset.forName("utf-8"));
  }

  public static String encode(String content) {
    return new String(Base64.getEncoder().encode(content.getBytes(Charset.forName("utf-8"))), Charset.forName("utf-8"));
  }
}
