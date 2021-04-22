package com.yunli.bigdata.dsep.service.common.dto.resource;

/**
 * @author david
 * @date 2020/9/21 10:28 上午
 */
public class DataResult {
  // ID编码信息
  private String id;

  // 编码信息
  private String code;

  public DataResult() {
  }

  public DataResult(String id, String code) {
    this.id = id;
    this.code = code;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
