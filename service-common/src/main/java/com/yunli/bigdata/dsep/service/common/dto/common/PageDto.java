package com.yunli.bigdata.dsep.service.common.dto.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 分页排序参数类
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/17 17:55
 */
@ApiModel(description = "分页对象")
public class PageDto implements Serializable {

  @ApiModelProperty(value = "当前的页数(default: 1)", example = "1")
  private Integer pageNum = 1;

  @ApiModelProperty(value = "每页显示的条数(default: 10)", example = "10")
  private Integer pageSize = 10;

  public PageDto() {
  }

  public PageDto(Integer pageNum, Integer pageSize) {
    this.pageNum = pageNum;
    this.pageSize = pageSize;
  }

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
}
