package com.yunli.bigdata.dsep.service.common;

/**
 * @author wangpengfei
 * @date 2019-06-26
 */
public class ExpiredTokenException extends Exception {
  public ExpiredTokenException(String msg) {
    super(msg);
  }
}
