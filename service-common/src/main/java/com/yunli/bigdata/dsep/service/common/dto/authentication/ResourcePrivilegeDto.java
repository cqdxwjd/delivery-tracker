package com.yunli.bigdata.dsep.service.common.dto.authentication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wei
 */
public class ResourcePrivilegeDto implements Serializable {
  private Long id;

  private String type;

  private String name;

  private Boolean canChange = false;

  private List<ActionDto> actions = new ArrayList<>();

  public ResourcePrivilegeDto() {
  }

  public ResourcePrivilegeDto(String type, String name, List<ActionDto> actions) {
    this.type = type;
    this.name = name;
    this.actions = actions;
  }

  public ResourcePrivilegeDto(Long id, String type, String name,
      List<ActionDto> actions) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.actions = actions;
  }

  public ResourcePrivilegeDto(Long id, String type, String name, Boolean canChange,
      List<ActionDto> actions) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.canChange = canChange;
    this.actions = actions;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getCanChange() {
    return canChange;
  }

  public void setCanChange(Boolean canChange) {
    this.canChange = canChange;
  }

  public List<ActionDto> getActions() {
    return actions;
  }

  public void setActions(List<ActionDto> actions) {
    this.actions = actions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourcePrivilegeDto that = (ResourcePrivilegeDto) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(type, that.type) &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, name);
  }
}
