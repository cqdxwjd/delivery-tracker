package com.yunli.bigdata.dsep.service.common.dto.resource;

/**
 * @author david
 * @date 2020/9/21 10:28 上午
 */
public class TagResult {
  // ID编码信息
  private String id;

  // 编码信息
  private String code;

  private DataResult dataResult;

  public TagResult() {
  }

  public TagResult(String id, String code, DataResult dataResult) {
    this.id = id;
    this.code = code;
    this.dataResult = dataResult;
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

  public DataResult getDataResult() {
    return dataResult;
  }

  public void setDataResult(DataResult dataResult) {
    this.dataResult = dataResult;
  }
}
