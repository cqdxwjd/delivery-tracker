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
@ApiModel(description = "创建文件夹")
public class CreateFolderRequest implements Serializable {

  @ApiModelProperty("父目录Id")
  private Long parentId;

  @ApiModelProperty("名称")
  @NotBlank(message = "名称不能为空")
  @Size(max = 100, message = "名称字符数不能超过100")
  private String name;

  public CreateFolderRequest() {
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
