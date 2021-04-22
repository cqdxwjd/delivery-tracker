package com.yunli.bigdata.dsep.foundation;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "分页响应结果")
public class PageResult<T> {
  @ApiModelProperty("响应码")
  private int code;

  @ApiModelProperty("响应消息")
  private String message;

  @ApiModelProperty("总分页数")
  private int totalPageCount;

  @ApiModelProperty("总记录数")
  private long totalElementCount;

  @ApiModelProperty("响应数据")
  private List<T> data;

  public static final int SUCCESS_CODE = 200;

  public static final String SUCCESS_MSG = "success";

  public static final int CREATE_CODE = 201;

  public PageResult() {
  }

  public PageResult(int code, String message, int totalPageCount, long totalElementCount, List<T> data) {
    this.code = code;
    this.message = message;
    this.totalPageCount = totalPageCount;
    this.totalElementCount = totalElementCount;
    this.data = data;
  }

  @JsonIgnore
  public boolean isSuccess() {
    return code == SUCCESS_CODE || code == CREATE_CODE;
  }

  public static <T> PageResult<T> success(int totalPageCount, long totalElementCount, List<T> data) {
    return new PageResult<>(SUCCESS_CODE, SUCCESS_MSG, totalPageCount, totalElementCount, data);
  }

  public static <T> PageResult<T> success(int code, int totalPageCount, long totalElementCount, List<T> data) {
    return new PageResult<>(code, SUCCESS_MSG, totalPageCount, totalElementCount, data);
  }

  public static <T> PageResult<T> error(int code, String message) {
    return new PageResult<>(code, message, 0, 0, new ArrayList<>());
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getTotalPageCount() {
    return totalPageCount;
  }

  public void setTotalPageCount(int totalPageCount) {
    this.totalPageCount = totalPageCount;
  }

  public long getTotalElementCount() {
    return totalElementCount;
  }

  public void setTotalElementCount(long totalElementCount) {
    this.totalElementCount = totalElementCount;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }
}
