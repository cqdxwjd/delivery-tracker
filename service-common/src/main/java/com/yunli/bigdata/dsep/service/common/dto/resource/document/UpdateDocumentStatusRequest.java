package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhangws
 */
@ApiModel(description = "修改文档状态")
public class UpdateDocumentStatusRequest implements Serializable {

  @ApiModelProperty(value = "文档ID", required = true)
  @NotNull(message = "ID不能为空")
  private List<Long> id;

  @ApiModelProperty("理由")
  private String reason;

  @ApiModelProperty(value = "状态", required = true)
  @NotNull(message = "状态不能为空")
  private Integer status;

  @ApiModelProperty(value = "是否停止对应数据表已启用的作业")
  private Boolean stopJobs;

  public UpdateDocumentStatusRequest() {
  }

  public UpdateDocumentStatusRequest(List<Long> id, String reason, Integer status, Boolean stopJobs) {
    this.id = id;
    this.reason = reason;
    this.status = status;
    this.stopJobs = stopJobs;
  }

  public List<Long> getId() {
    return id;
  }

  public void setId(List<Long> id) {
    this.id = id;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Boolean getStopJobs() {
    return stopJobs;
  }

  public void setStopJobs(Boolean stopJobs) {
    this.stopJobs = stopJobs;
  }
}
