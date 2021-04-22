package com.yunli.bigdata.dsep.service.common.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Privilege
 * @author wei
 */
@Validated
public class PrivilegeDto implements Serializable {
  @JsonProperty("resource_type")
  private String resourceType = null;

  @JsonProperty("resource_id")
  private long resourceId;

  @JsonProperty("action")
  private String action = null;

  @JsonProperty("properties")
  @Valid
  private Map<String, String> properties = new HashMap<>();

  public PrivilegeDto() {
  }

  public PrivilegeDto(String resourceType, long resourceId, String action) {
    this.resourceType = resourceType;
    this.resourceId = resourceId;
    this.action = action;
  }

  public PrivilegeDto resourceType(String resourceType) {
    this.resourceType = resourceType;
    return this;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public PrivilegeDto resourceId(long resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  public long getResourceId() {
    return resourceId;
  }

  public void setResourceId(long resourceId) {
    this.resourceId = resourceId;
  }

  public PrivilegeDto action(String action) {
    this.action = action;
    return this;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public PrivilegeDto properties(Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  public PrivilegeDto putPropertiesItem(String key, String propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }
    this.properties.put(key, propertiesItem);
    return this;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrivilegeDto that = (PrivilegeDto) o;
    return resourceId == that.resourceId &&
        Objects.equals(resourceType, that.resourceType) &&
        Objects.equals(action, that.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceType, resourceId, action);
  }
}
