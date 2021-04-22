package com.yunli.bigdata.dsep.service.common.dto.resource;

import com.yunli.bigdata.dsep.service.common.util.ValidateUtil;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 资源扩展属性
 * @author wei
 */
public class ExtendProperty {

  /**
   * 资源扩展属性ID（标签类型ID）
   */
  @ApiModelProperty("资源扩展属性ID（标签类型ID）")
  private Long extendPropertyId;

  /**
   * 资源扩展属性值的ID列表（标签值ID列表）
   */
  @ApiModelProperty("资源扩展属性值的ID列表（标签值ID列表）")
  private List<Long> extendPropertyValueIds;

  public ExtendProperty() {
  }

  public ExtendProperty(Long extendPropertyId) {
    this.extendPropertyId = extendPropertyId;
    this.extendPropertyValueIds = new ArrayList<>();
  }

  public ExtendProperty(Long extendPropertyId, List<Long> extendPropertyValueIds) {
    this.extendPropertyId = extendPropertyId;
    this.extendPropertyValueIds = extendPropertyValueIds;
  }

  public Long getExtendPropertyId() {
    return extendPropertyId;
  }

  public void setExtendPropertyId(Long extendPropertyId) {
    this.extendPropertyId = extendPropertyId;
  }

  public List<Long> getExtendPropertyValueIds() {
    return extendPropertyValueIds;
  }

  public void setExtendPropertyValueIds(List<Long> extendPropertyValueIds) {
    this.extendPropertyValueIds = extendPropertyValueIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtendProperty that = (ExtendProperty) o;
    return Objects.equals(extendPropertyId, that.extendPropertyId) && ValidateUtil
        .equals(extendPropertyValueIds, that.extendPropertyValueIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extendPropertyId);
  }

  @Override
  public String toString() {
    return "ExtendProperty{" +
        "extendPropertyId=" + extendPropertyId +
        ", extendPropertyValueIds=" + extendPropertyValueIds +
        '}';
  }
}
