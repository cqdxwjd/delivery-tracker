package com.yunli.bigdata.dsep.service.common.dto.authentication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wei
 */
public class LoginResultDto {
  private String token;

  private String userId;

  private String userName;

  private List<OrganizationDto> userOrganizations = new ArrayList<>();

  private boolean isAdmin = false;

  private String ssoLoginUrl = null;

  private List<String> menus = new ArrayList<>();

  public LoginResultDto() {
  }

  public LoginResultDto(String ssoLoginUrl) {
    this.ssoLoginUrl = ssoLoginUrl;
  }

  public LoginResultDto(String token, String userId, String userName,
      List<OrganizationDto> userOrganizations, String ssoLoginUrl, boolean isAdmin) {
    this.token = token;
    this.userId = userId;
    this.userName = userName;
    this.userOrganizations = userOrganizations;
    this.ssoLoginUrl = ssoLoginUrl;
    this.isAdmin = isAdmin;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public List<OrganizationDto> getUserOrganizations() {
    return userOrganizations;
  }

  public void setUserOrganizations(
      List<OrganizationDto> userOrganizations) {
    this.userOrganizations = userOrganizations;
  }

  public String getSsoLoginUrl() {
    return ssoLoginUrl;
  }

  public void setSsoLoginUrl(String ssoLoginUrl) {
    this.ssoLoginUrl = ssoLoginUrl;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  public List<String> getMenus() {
    return menus;
  }

  public void setMenus(List<String> menus) {
    this.menus = menus;
  }
}
