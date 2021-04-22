package com.yunli.bigdata.dsep.service.common.dto.authentication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wangpengfei
 * @date 2019-07-11
 *
 * for testing purpose
 */
public class UserDto implements Serializable {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("organization")
  private String organization;

  private List<Object> groups = new ArrayList<>();

  private List<Object> roles = new ArrayList<>();

  public UserDto() {
  }

  public UserDto(String id, String name, String organization) {
    this.id = id;
    this.name = name;
    this.organization = organization;
  }

  public UserDto(String id, String name, String organization, List<Long> groupIds, List<Long> roleIds) {
    this.id = id;
    this.name = name;
    this.organization = organization;
    this.groups.addAll(groupIds);
    this.roles.addAll(roleIds);
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
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

  public List<Object> getGroups() {
    return groups;
  }

  public void setGroups(List<Object> groups) {
    this.groups = groups;
  }

  public List<Object> getRoles() {
    return roles;
  }

  public void setRoles(List<Object> roles) {
    this.roles = roles;
  }
}
