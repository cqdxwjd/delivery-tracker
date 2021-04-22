package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 数据源类型编码对象
 * <p>
 * 用于下拉框
 *
 * @author zhangws 2019/07/03 10:20:00
 */
@ApiModel(description = "数据源类型编码对象")
public class DataSourceTypeCodeDto implements Serializable {

  @ApiModelProperty("名称")
  private String name;

  @ApiModelProperty("模板")
  private String template;

  public DataSourceTypeCodeDto(String name, String template) {
    this.name = name;
    this.template = template;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }
}
