package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;

/**
 * @author wei
 */
public class FilterResourcePartitionResponseDto implements Serializable {
  private Long partitionId;

  private String partition;

  public FilterResourcePartitionResponseDto() {
  }

  public FilterResourcePartitionResponseDto(Long partitionId, String partition) {
    this.partitionId = partitionId;
    this.partition = partition;
  }

  public Long getPartitionId() {
    return partitionId;
  }

  public void setPartitionId(Long partitionId) {
    this.partitionId = partitionId;
  }

  public String getPartition() {
    return partition;
  }

  public void setPartition(String partition) {
    this.partition = partition;
  }
}
