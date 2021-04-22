package com.yunli.bigdata.dsep.service.common.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author wangpengfei
 * @date 2019-07-02
 */
public class UpdateRoleDto implements Serializable {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  public UpdateRoleDto() {
  }

  public UpdateRoleDto(String name, String description) {
    this.name = name;
    this.description = description;
  }

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
