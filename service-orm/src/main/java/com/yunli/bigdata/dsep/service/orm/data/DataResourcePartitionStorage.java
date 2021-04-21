package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 数据表表分区存储信息(partition_storages)
 *
 * @author wei
 */
@Entity
@Table(name = "data_resource_partition_storages")
@EntityListeners(AuditingEntityListener.class)
public class DataResourcePartitionStorage implements Serializable {
  /** ID */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** 分区ID */
  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "resource_id")
  private DataResource resource;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "storage_id")
  private DataResourceStorage storage;

  @Column(name = "partition_serde")
  private String partitionSerDe;

  public DataResourcePartitionStorage() {
  }

  public DataResourcePartitionStorage(DataResource resource, DataResourceStorage storage,
      String partitionSerDe) {
    this.resource = resource;
    this.storage = storage;
    this.partitionSerDe = partitionSerDe;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DataResource getResource() {
    return resource;
  }

  public void setResource(DataResource resource) {
    this.resource = resource;
  }

  public DataResourceStorage getStorage() {
    return storage;
  }

  public void setStorage(DataResourceStorage storage) {
    this.storage = storage;
  }

  public String getPartitionSerDe() {
    return partitionSerDe;
  }

  public void setPartitionSerDe(String partitionSerDe) {
    this.partitionSerDe = partitionSerDe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataResourcePartitionStorage that = (DataResourcePartitionStorage) o;
    return Objects.equals(resource, that.resource) &&
        Objects.equals(storage, that.storage) &&
        Objects.equals(partitionSerDe, that.partitionSerDe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource, storage, partitionSerDe);
  }
}