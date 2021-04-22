package com.yunli.bigdata.dsep.service.common.dto.authentication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RoleAssignments
 */
@Validated
public class RoleAssignments implements Serializable {
  @JsonProperty("groups")
  @Valid
  private List<Long> groups = new ArrayList<>();

  @JsonProperty("users")
  @Valid
  private List<String> users = new ArrayList<>();

  public RoleAssignments groups(List<Long> groups) {
    this.groups = groups;
    return this;
  }

  public RoleAssignments addGroupsItem(Long groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * Get groups
   * @return groups
   **/
  @ApiModelProperty(value = "")

  public List<Long> getGroups() {
    return groups;
  }

  public void setGroups(List<Long> groups) {
    this.groups = groups;
  }

  public RoleAssignments users(List<String> users) {
    this.users = users;
    return this;
  }

  public RoleAssignments addUsersItem(String usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
   **/
  @ApiModelProperty(value = "")

  public List<String> getUsers() {
    return users;
  }

  public void setUsers(List<String> users) {
    this.users = users;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleAssignments roleAssignments = (RoleAssignments) o;
    return Objects.equals(this.groups, roleAssignments.groups) &&
        Objects.equals(this.users, roleAssignments.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groups, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleAssignments {\n");

    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
