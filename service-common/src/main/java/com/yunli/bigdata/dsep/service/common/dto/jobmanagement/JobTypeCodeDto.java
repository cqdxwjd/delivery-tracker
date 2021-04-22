package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 作业类型编码对象
 * <p>
 * 用于下拉框
 *
 * @author zhangws 2019/07/03 10:20:00
 */
@ApiModel(description = "作业类型编码对象")
public class JobTypeCodeDto implements Serializable {

  @ApiModelProperty("名称")
  private String name;

  public JobTypeCodeDto(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
