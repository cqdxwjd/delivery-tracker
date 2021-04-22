package com.yunli.bigdata.dsep.service.common.dto.statistics;

import java.io.Serializable;

/**
 * @author wei
 */
public class DataLineage implements Serializable {
  private LineageInfo organizations;

  private LineageInfo dataResource;

  private LineageInfo dataTheme;

  private LineageInfo dataScene;

  public DataLineage() {
  }

  public DataLineage(LineageInfo organizations,
      LineageInfo dataResource, LineageInfo dataTheme,
      LineageInfo dataScene) {
    this.organizations = organizations;
    this.dataResource = dataResource;
    this.dataTheme = dataTheme;
    this.dataScene = dataScene;
  }

  public LineageInfo getOrganizations() {
    return organizations;
  }

  public void setOrganizations(LineageInfo organizations) {
    this.organizations = organizations;
  }

  public LineageInfo getDataResource() {
    return dataResource;
  }

  public void setDataResource(LineageInfo dataResource) {
    this.dataResource = dataResource;
  }

  public LineageInfo getDataTheme() {
    return dataTheme;
  }

  public void setDataTheme(LineageInfo dataTheme) {
    this.dataTheme = dataTheme;
  }

  public LineageInfo getDataScene() {
    return dataScene;
  }

  public void setDataScene(LineageInfo dataScene) {
    this.dataScene = dataScene;
  }
}
