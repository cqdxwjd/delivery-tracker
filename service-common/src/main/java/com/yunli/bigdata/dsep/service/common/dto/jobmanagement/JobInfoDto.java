package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.constant.CommonConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: jiangxunyu
 * @date: 2019-07-12 22:25
 */
@ApiModel(description = "作业模型对象")
public class JobInfoDto implements Serializable {

  @ApiModelProperty("作业ID")
  private Long id;

  @ApiModelProperty("作业名称")
  private String name;

  @ApiModelProperty("作业类型")
  private String type;


  @ApiModelProperty("数据类型")
  private String resourceType;

  @ApiModelProperty("作业描述信息")
  private String description;

  @ApiModelProperty("责任人")
  private String owner;

  @ApiModelProperty("作业模板")
  private String template;

  @ApiModelProperty("作业开始时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date startTime;

  @ApiModelProperty("作业结束时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date endTime;

  @ApiModelProperty("作业参数")
  private String parameters;

  @ApiModelProperty("依赖作业的ID")
  private List<Long> depends;

  @ApiModelProperty("调度周期(0:分钟, 1:小时, 2:天, 3:周, 4:月)")
  @NotNull(message = "调度周期")
  private String cycle;

  @ApiModelProperty("调度详情")
  @NotNull(message = "调度详情")
  private String scheduleInfo;

  @ApiModelProperty("创建时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date createTime;

  @ApiModelProperty("更新时间")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  private Date updateTime;

  @ApiModelProperty("来源异常信息")
  private JobErrorMessage readerMessage;

  @ApiModelProperty("目标异常信息")
  private JobErrorMessage writerMessage;

  public JobInfoDto() {
  }

  public JobInfoDto(Long id, String name, String type, String resourceType, String description, String owner,
      Date createTime,
      Date updateTime) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.resourceType = resourceType;
    this.description = description;
    this.owner = owner;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
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

  public String getParameters() {
    return parameters;
  }

  public void setParameters(String parameters) {
    this.parameters = parameters;
  }

  public List<Long> getDepends() {
    return depends;
  }

  public void setDepends(List<Long> depends) {
    this.depends = depends;
  }

  public String getCycle() {
    return cycle;
  }

  public void setCycle(String cycle) {
    this.cycle = cycle;
  }

  public String getScheduleInfo() {
    return scheduleInfo;
  }

  public void setScheduleInfo(String scheduleInfo) {
    this.scheduleInfo = scheduleInfo;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public JobErrorMessage getReaderMessage() {
    return readerMessage;
  }

  public void setReaderMessage(JobErrorMessage readerMessage) {
    this.readerMessage = readerMessage;
  }

  public JobErrorMessage getWriterMessage() {
    return writerMessage;
  }

  public void setWriterMessage(JobErrorMessage writerMessage) {
    this.writerMessage = writerMessage;
  }
}
