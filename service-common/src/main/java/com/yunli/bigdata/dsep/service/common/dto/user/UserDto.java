package com.yunli.bigdata.dsep.service.common.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "用户")
public class UserDto implements Serializable {
  @ApiModelProperty("用户Id")
  private String id;

  @ApiModelProperty("用户名")
  private String name;

  @ApiModelProperty("电话号码")
  private String mobile;

  @ApiModelProperty("电子邮件")
  private String email;

  @ApiModelProperty("所属的组织机构列表")
  private String[] organizations;

  @ApiModelProperty("备注")
  private String remark;

  @ApiModelProperty("所属的角色列表")
  private String[] roles;

  @ApiModelProperty("其他额外信息")
  private String additional;

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

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String[] getOrganizations() {
    return organizations == null ? null : Arrays.copyOf(organizations,  organizations.length);
  }

  public void setOrganizations(String[] organizations) {
    if (null != organizations) {
      this.organizations = Arrays.copyOf(organizations, organizations.length);
    } else {
      this.organizations = new String[0];
    }
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String[] getRoles() {
    return roles == null ? null : Arrays.copyOf(roles,  roles.length);
  }

  public void setRoles(String[] roles) {
    if (null != roles) {
      this.roles = Arrays.copyOf(roles, roles.length);
    } else {
      this.roles = new String[0];
    }
  }

  public String getAdditional() {
    return additional;
  }

  public void setAdditional(String additional) {
    this.additional = additional;
  }

  public UserDto() {
  }

  public UserDto(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public UserDto(String id, String name, String mobile, String email, String[] organizations, String remark,
      String[] roles, String additional) {
    this.id = id;
    this.name = name;
    this.mobile = mobile;
    this.email = email;
    if (null != organizations) {
      this.organizations = Arrays.copyOf(organizations, organizations.length);
    } else {
      this.organizations = new String[0];
    }
    this.remark = remark;
    if (null != roles) {
      this.roles = Arrays.copyOf(roles, roles.length);
    } else {
      this.roles = new String[0];
    }
    this.additional = additional;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDto userDto = (UserDto) o;
    return Objects.equals(id, userDto.id);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id);
  }
}
