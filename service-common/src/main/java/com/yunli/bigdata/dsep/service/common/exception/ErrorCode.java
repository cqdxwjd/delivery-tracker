package com.yunli.bigdata.dsep.service.common.exception;

/**
 * 全局MessageCode接口
 *
 * @author zhangws
 */
public interface ErrorCode {

  // 错误码编号
  int getCode();

  // 错误码描述
  String getMessage();
}
