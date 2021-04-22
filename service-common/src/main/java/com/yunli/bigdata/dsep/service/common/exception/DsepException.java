package com.yunli.bigdata.dsep.service.common.exception;

/**
 * @author : jiangxunyu
 * @author zhangws 2019/07/08 扩展异常处理类，增加code
 * @Description: 自定义全局异常处理类
 * @CreateDate: 2019/6/18 10:28
 */
public class DsepException extends RuntimeException {

  private Integer code;

  private String message;

  public DsepException(Integer code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }

  public DsepException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }

  public DsepException(ErrorCode errorCode, Object... args) {
    super(String.format(errorCode.getMessage(), args));
    this.code = errorCode.getCode();
    this.message = super.getMessage();
  }

  public DsepException(Integer code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
