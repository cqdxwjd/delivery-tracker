package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunli.bigdata.dsep.service.common.constant.CommonConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 作业对象
 *
 * @author zhangws 2019/07/03 10:20:00
 */
@ApiModel(description = "作业对象")
public class UpdateJobRequest implements Serializable {

  @ApiModelProperty(value = "作业名称", required = true)
  @NotBlank(message = "作业名称不能为空")
  @Size(max = 90, message = "作业名称字符数不能超过90")
  private String name;

  @ApiModelProperty("作业描述信息")
  @Size(max = 200, message = "作业描述字符数不能超过200")
  private String description;

  @ApiModelProperty(value = "作业模板", example = "\"{}\"", required = true)
  @NotBlank(message = "作业模板不能为空")
  @Size(max = 20000, message = "作业模板字符数不能超过20000")
  private String template;

  @ApiModelProperty(value = "执行优化参数", example = "\"{}\"")
  @Size(max = 2000, message = "执行优化参数字符数不能超过2000")
  private String optimizerParams;

  @ApiModelProperty(value = "生效日期（开始）", example = "2019-01-01 00:00:00")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  @NotNull(message = "生效日期（开始）不能为空")
  private Date startTime;

  @ApiModelProperty(value = "生效日期（结束）", example = "2020-01-01 00:00:00")
  @JsonFormat(pattern = CommonConst.EXCHANGE_DATE_FORMAT, timezone = CommonConst.EXCHANGE_TIMEZONE_FORMAT)
  @NotNull(message = "生效日期（结束）不能为空")
  private Date endTime;

  @ApiModelProperty("作业参数")
  @Size(max = 2000, message = "作业参数字符数不能超过2000")
  private String parameters;

  @ApiModelProperty(value = "依赖作业的ID")
  private List<Long> depends;

  @ApiModelProperty(value = "调度周期（分钟、小时、日、周、月、仅一次)", example = "日")
  @NotBlank(message = "调度周期不能为空")
  @Size(max = 30, message = "调度周期字符数不能超过30")
  private String cycle;

  @ApiModelProperty(value = "调度详情", example = "\"{\"specificTime\":\"12:30\"}\"", required = true)
  @NotBlank(message = "调度详情不能为空")
  @Size(max = 200, message = "调度详情字符数不能超过200")
  private String scheduleInfo;

  @ApiModelProperty(value = "质量规则")
  @Size(max = 200, message = "质量规则字符数不能超过200")
  private String quality;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public String getOptimizerParams() {
    return optimizerParams;
  }

  public void setOptimizerParams(String optimizerParams) {
    this.optimizerParams = optimizerParams;
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

  public String getQuality() {
    return quality;
  }

  public void setQuality(String quality) {
    this.quality = quality;
  }
}
