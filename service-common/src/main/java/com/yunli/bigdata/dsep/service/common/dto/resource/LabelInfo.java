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
public class LabelInfo {

  /**
   * 标签类型ID
   */
  @ApiModelProperty("标签类型ID")
  private Long labelTypeId;

  /**
   * 标签值ID列表
   */
  @ApiModelProperty("标签值ID列表")
  private List<Long> labelValueIds;

  public LabelInfo() {
  }

  public LabelInfo(Long labelTypeId) {
    this.labelTypeId = labelTypeId;
    this.labelValueIds = new ArrayList<>();
  }

  public LabelInfo(Long labelTypeId, List<Long> labelValueIds) {
    this.labelTypeId = labelTypeId;
    this.labelValueIds = labelValueIds;
  }

  public Long getLabelTypeId() {
    return labelTypeId;
  }

  public void setLabelTypeId(Long labelTypeId) {
    this.labelTypeId = labelTypeId;
  }

  public List<Long> getLabelValueIds() {
    return labelValueIds;
  }

  public void setLabelValueIds(List<Long> labelValueIds) {
    this.labelValueIds = labelValueIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LabelInfo that = (LabelInfo) o;
    return Objects.equals(labelTypeId, that.labelTypeId) && ValidateUtil
        .equals(labelValueIds, that.labelValueIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(labelTypeId);
  }

  @Override
  public String toString() {
    return "LabelInfo{" +
        "labelTypeId=" + labelTypeId +
        ", labelValueIds=" + labelValueIds +
        '}';
  }
}
