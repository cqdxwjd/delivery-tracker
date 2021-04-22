package com.yunli.bigdata.dsep.service.common.dto.authentication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wei
 */
public class RoleOrGroupPrivilegeDto implements Serializable {
  private String code;

  private String name;

  private List<ResourcePrivilegeDto> resourcePrivileges = new ArrayList<>();

  public RoleOrGroupPrivilegeDto() {
  }

  public RoleOrGroupPrivilegeDto(String code, String name,
      List<ResourcePrivilegeDto> resourcePrivileges) {
    this.code = code;
    this.name = name;
    this.resourcePrivileges = resourcePrivileges;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ResourcePrivilegeDto> getResourcePrivileges() {
    return resourcePrivileges;
  }

  public void setResourcePrivileges(List<ResourcePrivilegeDto> resourcePrivileges) {
    this.resourcePrivileges = resourcePrivileges;
  }
}
