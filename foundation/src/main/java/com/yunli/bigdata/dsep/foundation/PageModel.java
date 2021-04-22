package com.yunli.bigdata.dsep.foundation;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 分页数据模型对象
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/18 18:11
 */
@ApiModel(description = "分页数据模型对象")
public class PageModel<T> {

  @ApiModelProperty("总记录数")
  private Long elementCount;

  @ApiModelProperty("总页数")
  private Integer pageCount;

  @ApiModelProperty("每页显示的数据")
  private List<T> data;

  public PageModel() {
  }

  public PageModel(Long elementCount, Integer pageCount, List<T> data) {
    this.elementCount = elementCount;
    this.pageCount = pageCount;
    this.data = data;
  }

  public static <T> PageModel<T> def() {
    return new PageModel<>(0L, 1, new ArrayList<>());
  }

  public Long getElementCount() {
    return elementCount;
  }

  public void setElementCount(Long elementCount) {
    this.elementCount = elementCount;
  }

  public Integer getPageCount() {
    return pageCount;
  }

  public void setPageCount(Integer pageCount) {
    this.pageCount = pageCount;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }
}
