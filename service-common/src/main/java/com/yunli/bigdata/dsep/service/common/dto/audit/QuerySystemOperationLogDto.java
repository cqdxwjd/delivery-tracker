package com.yunli.bigdata.dsep.service.common.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "系统操作审计日志")
public class QuerySystemOperationLogDto implements Serializable {
  @ApiModelProperty("对象类型")
  private String targetType;

  @ApiModelProperty("对象名称")
  private String targetName;

  @ApiModelProperty("操作类型")
  private String operationType;

  @ApiModelProperty("对象组织机构名称")
  private String organizationName;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("开始时间")
  private Date startTime;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("结束时间")
  private Date endTime;

  public QuerySystemOperationLogDto() {
  }

  public QuerySystemOperationLogDto(String targetType, String targetName, String operationType,
      String organizationName, Date startTime, Date endTime) {
    this.targetType = targetType;
    this.targetName = targetName;
    this.operationType = operationType;
    this.organizationName = organizationName;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public String getTargetType() {
    return targetType;
  }

  public void setTargetType(String targetType) {
    this.targetType = targetType;
  }

  public String getTargetName() {
    return targetName;
  }

  public void setTargetName(String targetName) {
    this.targetName = targetName;
  }

  public String getOperationType() {
    return operationType;
  }

  public void setOperationType(String operationType) {
    this.operationType = operationType;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  @Override
  public String toString() {
    return "QuerySystemOperationLogDto{" +
        "targetType='" + targetType + '\'' +
        ", targetName=" + targetName +
        ", operationType=" + operationType +
        ", organizationId='" + organizationName + '\'' +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        '}';
  }
}
