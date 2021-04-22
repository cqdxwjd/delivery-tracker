package com.yunli.bigdata.dsep.service.common.dto.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "组织机构")
public class OrganizationDto implements Serializable {
  @ApiModelProperty("组织机构Id")
  private String id;

  @ApiModelProperty("组织机构名")
  private String name;

  @ApiModelProperty("父组织机构Id")
  private String parentId;

  @ApiModelProperty("同目录下排序")
  private String order;

  @ApiModelProperty("其他额外信息")
  private String additional;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public String getAdditional() {
    return additional;
  }

  public void setAdditional(String additional) {
    this.additional = additional;
  }

  public OrganizationDto() {
  }

  public OrganizationDto(String id, String name, String parentId, String order, String additional) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.order = order;
    this.additional = additional;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationDto that = (OrganizationDto) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id);
  }
}
