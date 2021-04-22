package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @Description:
 * @Author: jiangxunyu
 * @CreateDate: 2019/8/1 14:08
 */
@ApiModel(description = "修改作业状态对象")
public class UpdateJobStatusRequest implements Serializable {

  @ApiModelProperty(value = "作业状态(0: 启动, 1: 停止)", required = true, allowableValues = "0,1")
  @NotNull(message = "作业状态不能为空")
  private Integer status;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
