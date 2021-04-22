package com.yunli.bigdata.dsep.service.common.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author wangpengfei
 * @date 2019-07-11
 *
 * for testing purpose
 */
public class OrganizationDto implements Serializable {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("parent")
  private String parent;

  public OrganizationDto() {
  }

  public OrganizationDto(String id, String name, String parent) {
    this.id = id;
    this.name = name;
    this.parent = parent;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

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
}
