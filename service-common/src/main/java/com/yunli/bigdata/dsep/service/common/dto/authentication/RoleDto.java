package com.yunli.bigdata.dsep.service.common.dto.authentication;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangpengfei
 * @date 2019-07-02
 */
public class RoleDto implements Serializable {
  @JsonProperty("id")
  private long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("create_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @JsonProperty("last_update_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date lastUpdateTime;

  @JsonProperty("creator")
  private String creator;

  @JsonProperty("modifier")
  private String modifier;

  @JsonProperty("properties")
  private Map<String, Object> properties = new HashMap<>();

  public RoleDto() {
  }

  public RoleDto(long id, String name, String description, Date createTime, Date lastUpdateTime) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.createTime = createTime;
    this.lastUpdateTime = lastUpdateTime;
  }

  public RoleDto id(long id) {
    this.id = id;
    return this;
  }

  public RoleDto name(String name) {
    this.name = name;
    return this;
  }

  public RoleDto properties(Map<String, Object> properties) {
    this.properties = properties;
    return this;
  }

  public RoleDto description(String description) {
    this.description = description;
    return this;
  }

  public RoleDto createTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

  public RoleDto lastUpdateTime(Date lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public RoleDto creator(String creator) {
    this.creator = creator;
    return this;
  }

  public RoleDto modifier(String modifier) {
    this.creator = modifier;
    return this;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(Date lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getModifier() {
    return modifier;
  }

  public void setModifier(String modifier) {
    this.modifier = modifier;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RoleDto putPropertiesItem(String key, String propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }
    this.properties.put(key, propertiesItem);
    return this;
  }

  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }
}
