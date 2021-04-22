package com.yunli.bigdata.dsep.service.common.dto.resource.label;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * @author zhangws
 */
public class LabelProperty {

  @ApiModelProperty("标签属性ID")
  private Long id;

  @ApiModelProperty("标签属性值")
  private String value;

  public LabelProperty() {
  }

  public LabelProperty(Long id, String value) {
    this.id = id;
    this.value = value;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LabelProperty that = (LabelProperty) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, value);
  }

  @Override
  public String toString() {
    return "ExtendPropertyInfo{" +
        "extendPropertyValueId=" + id +
        ", extendPropertyValue='" + value + '\'' +
        '}';
  }
}
