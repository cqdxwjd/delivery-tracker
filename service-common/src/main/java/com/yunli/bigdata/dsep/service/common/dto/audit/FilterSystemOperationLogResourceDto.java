package com.yunli.bigdata.dsep.service.common.dto.audit;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhengyangyong
 */
@ApiModel(description = "查询数据访问审计日志参数对象")
public class FilterSystemOperationLogResourceDto implements Serializable {
  @ApiModelProperty("对象类型")
  private String targetType;

  @ApiModelProperty("对象名称")
  private String targetName;

  @ApiModelProperty("对象编码")
  private String targetIds;

  @ApiModelProperty("操作类型")
  private String operationType;

  @ApiModelProperty("操作组织")
  private String organizationName;

  @ApiModelProperty("操作人")
  private String userName;

  @ApiModelProperty("操作内容")
  private String operationContent;

  @ApiModelProperty("操作时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date operationTime;

  public FilterSystemOperationLogResourceDto() {
  }

  public FilterSystemOperationLogResourceDto(String targetType, String targetIds, String targetName, String operationType,
      String organizationName, String userName, String operationContent, Date operationTime) {
    this.targetType = targetType;
    this.targetIds = targetIds;
    this.targetName = targetName;
    this.operationType = operationType;
    this.organizationName = organizationName;
    this.userName = userName;
    this.operationContent = operationContent;
    this.operationTime = operationTime;
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

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getOperationContent() {
    return operationContent;
  }

  public void setOperationContent(String operationContent) {
    this.operationContent = operationContent;
  }

  public Date getOperationTime() {
    return operationTime;
  }

  public void setOperationTime(Date operationTime) {
    this.operationTime = operationTime;
  }

  public String getTargetIds() {
    return targetIds;
  }

  public void setTargetIds(String targetIds) {
    this.targetIds = targetIds;
  }

  @Override
  public String toString() {
    return "FilterSystemOperationLogResourceDto{" +
        "targetType='" + targetType + '\'' +
        ", targetIds=" + targetIds +
        ", targetName=" + targetName +
        ", operationType=" + operationType +
        ", organizationName='" + organizationName + '\'' +
        ", userName='" + userName + '\'' +
        ", operationTime=" + operationTime +
        '}';
  }
}
