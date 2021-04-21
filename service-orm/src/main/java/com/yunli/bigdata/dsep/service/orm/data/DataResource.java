package com.yunli.bigdata.dsep.service.orm.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yunli.bigdata.dsep.service.common.dto.resource.PartitionSpecInfo;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * 数据存储信息信息表(data_resources)
 *
 * @author wei
 */
@Entity
@Table(name = "data_resources")
@EntityListeners(AuditingEntityListener.class)
public class DataResource implements Serializable {
  /** 资源id */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** 资源表名称（英文） */
  @Column(name = "name_en")
  private String nameEn;

  /** 资源表名称（中文） */
  @Column(name = "name_cn")
  private String nameCn;

  /** 资源概要描述 */
  @Column(name = "description")
  private String description;

  /** 资源状态（对应是否发布：0-未发布(初始状态), 1-发布审核中, 2-已发布, 3-变更审核中, 4-下架审核中, 5-关联目录审核中, 6-加载数据审核中, 7-数据加载中 */
  @Column(name = "status")
  private Integer status;

  /** 数据导入审批类型，默认0（0-不需审批，1-数据质量异常时审批，2-必须审批） */
  @Column(name = "data_import_approval_type")
  private Integer dataImportApprovalType = 0;

  /** 共享类型（0-有条件共享，1-无条件共享，2-不予共享） */
  @Column(name = "sharing_type")
  private Integer sharingType = 0;

  /** 共享条件 */
  @Column(name = "sharing_condition")
  private String sharingCondition;

  /** 是否向社会开放(默认false) */
  @Column(name = "open_to_society")
  private Boolean openToSociety = false;

  /** 开放条件*/
  @Column(name = "open_condition")
  private String openCondition;

  /** 是否需要交互式查询(默认false) */
  @Column(name = "interactive_query")
  private Boolean interactiveQuery = false;

  /** 数据表数量*/
  @Column(name = "count")
  private Long count = 0L;

  @CreatedDate
  @Column(name = "create_time")
  private Date createTime;

  /** 发布时间 */
  @Column(name = "published_time")
  private Date publishedTime;

  /** 更新时间 */
  @LastModifiedDate
  @Column(name = "update_time")
  private Date updateTime;

  @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
  @JoinTable(name = "resource_tag",
      joinColumns = @JoinColumn(name = "resource_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private Set<DataTag> tags = new HashSet<>();

  @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
  @JoinTable(name = "resource_storage",
      joinColumns = @JoinColumn(name = "resource_id"),
      inverseJoinColumns = @JoinColumn(name = "storage_id"))
  private Set<DataResourceStorage> storages = new HashSet<>();

  @OneToMany(mappedBy = "resource", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<DataResourceColumn> columns = new ArrayList<>();

  @OneToMany(mappedBy = "resource", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private Set<DataResourcePartitionStorage> partitions = new HashSet<>();

  @OneToMany(mappedBy = "resource", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private List<DataResourceExtendValues> extendValues = new ArrayList<>();

  public DataResource() {
  }

  public DataResource(String nameEn, String nameCn, String description, Integer status,
      Integer dataImportApprovalType, Integer sharingType, String sharingCondition, Boolean openToSociety,
      String openCondition, Boolean interactiveQuery) {
    this.nameEn = nameEn;
    this.nameCn = nameCn;
    this.description = description;
    this.status = status;
    this.dataImportApprovalType = dataImportApprovalType;
    this.sharingType = sharingType;
    this.sharingCondition = sharingCondition;
    this.openToSociety = openToSociety;
    this.openCondition = openCondition;
    this.interactiveQuery = interactiveQuery;
  }

  /**
   * 获取资源id
   *
   * @return 资源id
   */
  public Long getId() {
    return this.id;
  }

  /**
   * 设置资源id
   *
   * @param id 资源id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取资源表名称（英文）
   *
   * @return 资源表名称（英文）
   */
  public String getNameEn() {
    return this.nameEn;
  }

  /**
   * 设置资源表名称（英文）
   *
   * @param nameEn 资源表名称（英文）
   */
  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }

  /**
   * 获取资源表名称（中文）
   *
   * @return 资源表名称（中文）
   */
  public String getNameCn() {
    return this.nameCn;
  }

  /**
   * 设置资源表名称（中文）
   *
   * @param nameCn 资源表名称（中文）
   */
  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }

  /**
   * 获取资源概要描述
   *
   * @return 资源概要描述
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * 设置资源概要描述
   *
   * @param description 资源概要描述
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 获取资源状态（对应是否发布：0-未发布(初始状态), 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布
   *
   * @return 资源状态（对应是否发布：0-未发布(初始状态)
   */
  public Integer getStatus() {
    return this.status;
  }

  /**
   * 设置资源状态（对应是否发布：0-未发布(初始状态), 1-发布审批中, 2-变更审批中, 3-下架审批中, 4-已发布
   *
   * @param status 资源状态（对应是否发布：0-未发布(初始状态)
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * 获取数据导入审批类型，默认0（0-不需审批，1-数据质量异常时审批，2-必须审批）
   *
   * @return 数据导入审批类型
   */
  public Integer getDataImportApprovalType() {
    return this.dataImportApprovalType;
  }

  /**
   * 设置数据导入审批类型，默认0（0-不需审批，1-数据质量异常时审批，2-必须审批）
   *
   * @param dataImportApprovalType 数据导入审批类型
   */
  public void setDataImportApprovalType(Integer dataImportApprovalType) {
    this.dataImportApprovalType = dataImportApprovalType;
  }

  public Integer getSharingType() {
    return sharingType;
  }

  public void setSharingType(Integer sharingType) {
    this.sharingType = sharingType;
  }

  public String getSharingCondition() {
    return sharingCondition;
  }

  public void setSharingCondition(String sharingCondition) {
    this.sharingCondition = sharingCondition;
  }

  public Boolean getOpenToSociety() {
    return openToSociety;
  }

  public void setOpenToSociety(Boolean openToSociety) {
    this.openToSociety = openToSociety;
  }

  public String getOpenCondition() {
    return openCondition;
  }

  public void setOpenCondition(String openCondition) {
    this.openCondition = openCondition;
  }

  public Date getPublishedTime() {
    return publishedTime;
  }

  public void setPublishedTime(Date publishedTime) {
    this.publishedTime = publishedTime;
  }

  public Boolean getInteractiveQuery() {
    return interactiveQuery;
  }

  public void setInteractiveQuery(Boolean interactiveQuery) {
    this.interactiveQuery = interactiveQuery;
  }

  /**
   * 获取创建时间
   *
   * @return 创建时间
   */
  public Date getCreateTime() {
    return this.createTime;
  }

  /**
   * 设置创建时间
   *
   * @param createTime 创建时间
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 获取更新时间
   *
   * @return 更新时间
   */
  public Date getUpdateTime() {
    return this.updateTime;
  }

  /**
   * 设置更新时间
   *
   * @param updateTime 更新时间
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Set<DataTag> getTags() {
    return tags;
  }

  public void setTags(Set<DataTag> tags) {
    if (this.tags != null) {
      for (DataTag tag : this.tags) {
        tag.getResources().remove(this);
      }
    }
    if (tags != null) {
      for (DataTag tag : tags) {
        tag.getResources().add(this);
      }
    }
    this.tags = tags;
  }

  public List<DataResourceColumn> getColumns() {
    return columns;
  }

  public void setColumns(List<DataResourceColumn> columns) {
    this.columns = columns;
  }

  public Set<DataResourcePartitionStorage> getPartitions() {
    return partitions;
  }

  public void setPartitions(Set<DataResourcePartitionStorage> partitions) {
    this.partitions = partitions;
  }

  public Set<DataResourceStorage> getStorages() {
    return storages;
  }

  public void setStorages(Set<DataResourceStorage> storages) {
    if (this.storages != null) {
      for (DataResourceStorage storage : this.storages) {
        storage.getResources().remove(this);
      }
    }
    if (storages != null) {
      for (DataResourceStorage storage : storages) {
        storage.getResources().add(this);
      }
    }
    this.storages = storages;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public List<DataResourceExtendValues> getExtendValues() {
    return extendValues;
  }

  public void setExtendValues(List<DataResourceExtendValues> extendValues) {
    this.extendValues = extendValues;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataResource that = (DataResource) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(nameEn, that.nameEn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nameEn);
  }

  /**
   * 判断数据表是否包含分区
   * @param partitionSpecs 分区信息
   * @return 结果
   */
  public boolean containsPartition(Set<PartitionSpecInfo> partitionSpecs) {
    if (partitions != null) {
      for (DataResourcePartitionStorage partition : partitions) {
        String serDe = partition.getPartitionSerDe();
        String[] partitionColumns = serDe.replace("'", "").split(",");
        Set<PartitionSpecInfo> specInfo = new HashSet<>();
        for (String partitionColumn : partitionColumns) {
          String[] columnValue = partitionColumn.split("=");
          if (columnValue.length == 2) {
            specInfo.add(new PartitionSpecInfo(columnValue[0], columnValue[1]));
          }
        }
        if (specInfo.containsAll(partitionSpecs)) {
          return true;
        }
      }
    }
    return false;
  }

  @JsonIgnore
  public boolean isPartitionTable() {
    Set<DataResourceColumn> columns = new HashSet<>(this.columns);
    // 获取分区表
    columns.removeIf(column -> !column.isPartitionColumn());
    return columns.size() > 0;
  }
}