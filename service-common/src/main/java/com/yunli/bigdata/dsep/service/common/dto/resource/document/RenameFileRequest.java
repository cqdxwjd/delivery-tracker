package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 修改数据表状态的参数对象
 *
 * @author wei
 */
@ApiModel(description = "重命名文件")
public class RenameFileRequest implements Serializable {

  @ApiModelProperty("新名称")
  @NotBlank(message = "文件新名称不能为空")
  private String oldName;

  @ApiModelProperty("新名称")
  @NotBlank(message = "文件新名称不能为空")
  @Size(max = 100, message = "文件新名称字符数不能超过100")
  private String name;

  public RenameFileRequest() {
  }

  public String getOldName() {
    return oldName;
  }

  public void setOldName(String oldName) {
    this.oldName = oldName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
