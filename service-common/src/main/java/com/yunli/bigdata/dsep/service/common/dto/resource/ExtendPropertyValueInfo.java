package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wei
 */
public class ExtendPropertyValueInfo {

  /**
   * 资源扩展属性值的ID（标签值ID）
   */
  @ApiModelProperty("资源扩展属性值的ID（标签值ID）")
  private Long extendPropertyValueId;

  /**
   * 资源扩展属性值（标签值）
   */
  @ApiModelProperty("资源扩展属性值（标签值）")
  private String extendPropertyValue;

  public ExtendPropertyValueInfo() {
  }

  public ExtendPropertyValueInfo(Long extendPropertyValueId, String extendPropertyValue) {
    this.extendPropertyValueId = extendPropertyValueId;
    this.extendPropertyValue = extendPropertyValue;
  }

  public Long getExtendPropertyValueId() {
    return extendPropertyValueId;
  }

  public void setExtendPropertyValueId(Long extendPropertyValueId) {
    this.extendPropertyValueId = extendPropertyValueId;
  }

  public String getExtendPropertyValue() {
    return extendPropertyValue;
  }

  public void setExtendPropertyValue(String extendPropertyValue) {
    this.extendPropertyValue = extendPropertyValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtendPropertyValueInfo that = (ExtendPropertyValueInfo) o;
    return Objects.equals(extendPropertyValueId, that.extendPropertyValueId) &&
        Objects.equals(extendPropertyValue, that.extendPropertyValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extendPropertyValueId, extendPropertyValue);
  }

  @Override
  public String toString() {
    return "ExtendPropertyInfo{" +
        "extendPropertyValueId=" + extendPropertyValueId +
        ", extendPropertyValue='" + extendPropertyValue + '\'' +
        '}';
  }
}
