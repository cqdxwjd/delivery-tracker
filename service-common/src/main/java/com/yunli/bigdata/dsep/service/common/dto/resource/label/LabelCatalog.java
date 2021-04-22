package com.yunli.bigdata.dsep.service.common.dto.resource.label;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangws
 */
public class LabelCatalog {

  @ApiModelProperty("标签分类ID")
  private Long id;

  @ApiModelProperty("标签分类名称）")
  private String name;

  private List<LabelProperty> properties = new ArrayList<>();

  public LabelCatalog() {
    this.properties = new ArrayList<>();
  }

  public LabelCatalog(Long id, String name) {
    this.id = id;
    this.name = name;
    this.properties = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<LabelProperty> getProperties() {
    return properties;
  }

  public void setProperties(List<LabelProperty> properties) {
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
    LabelCatalog that = (LabelCatalog) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "LabelCatalog{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", properties=" + properties +
        '}';
  }
}
