package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * 资源扩展属性
 * @author wei
 */
public class GetExtendProperty {
  /**
   * 资源扩展属性ID（标签类型ID）
   */
  @ApiModelProperty("资源扩展属性ID（标签类型ID）")
  private Long extendPropertyId;

  /**
   * 资源扩展属性名称（标签类型）
   */
  @ApiModelProperty("资源扩展属性名称（标签类型）")
  private String extendPropertyName;

  private List<ExtendPropertyValueInfo> extendPropertyValueInfos;

  public GetExtendProperty() {
    this.extendPropertyValueInfos = new ArrayList<>();
  }

  public GetExtendProperty(Long extendPropertyId, String extendPropertyName) {
    this.extendPropertyId = extendPropertyId;
    this.extendPropertyName = extendPropertyName;
    this.extendPropertyValueInfos = new ArrayList<>();
  }

  public Long getExtendPropertyId() {
    return extendPropertyId;
  }

  public void setExtendPropertyId(Long extendPropertyId) {
    this.extendPropertyId = extendPropertyId;
  }

  public String getExtendPropertyName() {
    return extendPropertyName;
  }

  public void setExtendPropertyName(String extendPropertyName) {
    this.extendPropertyName = extendPropertyName;
  }

  public List<ExtendPropertyValueInfo> getExtendPropertyValueInfos() {
    return extendPropertyValueInfos;
  }

  public void setExtendPropertyValueInfos(
      List<ExtendPropertyValueInfo> extendPropertyValueInfos) {
    this.extendPropertyValueInfos = extendPropertyValueInfos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetExtendProperty that = (GetExtendProperty) o;
    return Objects.equals(extendPropertyId, that.extendPropertyId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extendPropertyId);
  }

  @Override
  public String toString() {
    return "GetExtendProperty{" +
        "extendPropertyId=" + extendPropertyId +
        ", extendPropertyName='" + extendPropertyName + '\'' +
        ", extendPropertyValueInfos=" + extendPropertyValueInfos +
        '}';
  }
}
