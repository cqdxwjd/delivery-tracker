package com.yunli.bigdata.dsep.service.common.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.*;

/**
 * Responsible
 */
@Validated
public class Responsible implements Serializable {
  @JsonProperty("organization")
  private String organization = null;

  @JsonProperty("organizationName")
  private String organizationName = null;

  @JsonProperty("users")
  @Valid
  private List<String> users = new ArrayList<>();

  @JsonProperty("userNames")
  @Valid
  private List<String> userNames = new ArrayList<>();

  @JsonProperty("properties")
  @Valid
  private Map<String, String> properties = new HashMap<>();

  public Responsible organization(String organization) {
    this.organization = organization;
    return this;
  }

  /**
   * Get orgnization
   * @return orgnization
   **/
  @ApiModelProperty(value = "")

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public Responsible users(List<String> users) {
    this.users = users;
    return this;
  }

  public Responsible addUsersItem(String usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  public Responsible addUserNamesItem(String userName) {
    if (this.userNames == null) {
      this.userNames = new ArrayList<>();
    }
    this.userNames.add(userName);
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

  public Responsible properties(Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  public Responsible putPropertiesItem(String key, String propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }
    this.properties.put(key, propertiesItem);
    return this;
  }

  /**
   * Get properties
   * @return properties
   **/
  @ApiModelProperty(value = "")

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public List<String> getUserNames() {
    return userNames;
  }

  public void setUserNames(List<String> userNames) {
    this.userNames = userNames;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Responsible responsible = (Responsible) o;
    return Objects.equals(this.organization, responsible.organization) &&
        Objects.equals(this.users, responsible.users) &&
        Objects.equals(this.properties, responsible.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organization, users, properties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Responsible {\n");

    sb.append("    orgnization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
