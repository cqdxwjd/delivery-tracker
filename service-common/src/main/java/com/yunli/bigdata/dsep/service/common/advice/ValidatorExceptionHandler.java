package com.yunli.bigdata.dsep.service.common.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yunli.bigdata.dsep.foundation.Result;

/**
 * 拦截参数校验异常，统一进行返回处理
 *
 * @author zhangws 2019/07/08
 */
@ControllerAdvice
public class ValidatorExceptionHandler extends ResponseEntityExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  @Nullable
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    List<String> errors = ex.getBindingResult().getFieldErrors().stream()
        .map(FieldError::getDefaultMessage)
        .collect(Collectors.toList());

    String requestPath;
    if (request instanceof ServletWebRequest) {
      requestPath = ((ServletWebRequest) request).getRequest().getRequestURI();
    } else {
      requestPath = request.getContextPath();
    }

    logger.error("请求：{} 发生异常：{}", requestPath, errors);

    return new ResponseEntity<>(Result.error(1101, errors.toString()), headers, HttpStatus.BAD_REQUEST);
  }

  @Override
  @Nullable
  protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    String requestPath;
    if (request instanceof ServletWebRequest) {
      requestPath = ((ServletWebRequest) request).getRequest().getRequestURI();
    } else {
      requestPath = request.getContextPath();
    }

    logger.error("请求：{} 发生异常：{}", requestPath, ex.getMessage());

    return new ResponseEntity<>(Result.error(1101, ex.getMessage()), headers, HttpStatus.BAD_REQUEST);
  }

  //  /**
//   * 自定义注解异常拦截
//   */
//  @ExceptionHandler({BindException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
//  public Object handleMethodArgumentNotValidException(Exception e, HttpServletRequest request,
//      HttpServletResponse response) {
//
//    // 错误信息
//    StringBuilder sb = new StringBuilder();
//
//    String msg;
//    if (!(e instanceof BindException) && !(e instanceof MethodArgumentNotValidException)) {
//      for (ConstraintViolation cv : ((ConstraintViolationException) e).getConstraintViolations()) {
//        msg = cv.getMessage();
//        sb.append(msg).append(";");
//      }
//    } else {
//      List<ObjectError> allErrors;
//      if (e instanceof BindException) {
//        allErrors = ((BindException) e).getAllErrors();
//      } else {
//        allErrors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
//      }
//      // 拼接错误信息
//      for (ObjectError oe : allErrors) {
//        msg = oe.getDefaultMessage();
//        sb.append(msg).append(";");
//      }
//    }
//    msg = sb.toString();
//    logger.error("请求：{} 发生异常：{}", request.getRequestURI(), msg);
//
//    response.setStatus(ResponseCode.BAD_REQUEST_CODE);
//    return Result.error(1101, msg);
//  }
}
