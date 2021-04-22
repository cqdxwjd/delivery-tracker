package com.yunli.bigdata.dsep.service.common.dto.authentication;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author wei
 */
public class QueryMenuDto implements Serializable {
  @ApiModelProperty("菜单编码")
  private String code;

  @ApiModelProperty("菜单名称")
  private String name;

  @ApiModelProperty("上级菜单")
  private Long parentId;

  @ApiModelProperty("菜单层级")
  private Integer level;

  @ApiModelProperty("菜单状态（0:停用，1:启用）")
  private Integer status;

  public QueryMenuDto() {
  }

  public QueryMenuDto(Integer status) {
    this.status = status;
  }

  public QueryMenuDto(String code, String name, Long parentId, Integer level, Integer status) {
    this.code = code;
    this.name = name;
    this.parentId = parentId;
    this.level = level;
    this.status = status;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryMenuDto menuDto = (QueryMenuDto) o;
    return Objects.equals(code, menuDto.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    return "QueryMenuDto{" +
        "code='" + code + '\'' +
        ", name='" + name + '\'' +
        ", parentId=" + parentId +
        ", level=" + level +
        ", status=" + status +
        '}';
  }
}
