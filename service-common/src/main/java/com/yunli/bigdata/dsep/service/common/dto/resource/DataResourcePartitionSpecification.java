package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author wei
 */
public class DataResourcePartitionSpecification implements Serializable {
  /** 分区列 */
  private String partitionColumn;

  /** 分区值 */
  private String partitionValue;

  public DataResourcePartitionSpecification() {
  }

  public DataResourcePartitionSpecification(String partitionColumn, String partitionValue) {
    this.partitionColumn = partitionColumn;
    this.partitionValue = partitionValue;
  }

  public String getPartitionColumn() {
    return partitionColumn;
  }

  public void setPartitionColumn(String partitionColumn) {
    this.partitionColumn = partitionColumn;
  }

  public String getPartitionValue() {
    return partitionValue;
  }

  public void setPartitionValue(String partitionValue) {
    this.partitionValue = partitionValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataResourcePartitionSpecification that = (DataResourcePartitionSpecification) o;
    return Objects.equals(partitionColumn, that.partitionColumn) &&
        Objects.equals(partitionValue, that.partitionValue);
  }

  @Override
  public int hashCode() {

    return Objects.hash(partitionColumn, partitionValue);
  }
}