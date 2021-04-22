package com.yunli.bigdata.dsep.service.common.dto.authentication;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Group
 * @author wei
 */
public class AddGroupDto implements Serializable {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  public AddGroupDto() {
  }

  public AddGroupDto(String name, String description) {
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
