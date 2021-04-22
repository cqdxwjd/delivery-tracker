package com.yunli.bigdata.dsep.service.common.dto.tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Description: 添加数据标签参数对象
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/17 16:51
 */
@ApiModel(description = "修改数据标签树参数对象")
public class EditDataTagTreeDto implements Serializable {

  @ApiModelProperty("标签树名称")
  @NotBlank(message = "名称不能为空")
  @Size(max = 30, message = "目录树名称字符数不能超过30")
  private String name;

  @ApiModelProperty("标签树描述信息")
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
