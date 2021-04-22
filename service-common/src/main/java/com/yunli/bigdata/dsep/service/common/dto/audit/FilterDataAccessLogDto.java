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
public class FilterDataAccessLogDto implements Serializable {
  @ApiModelProperty("访问者")
  private String userName;

  @ApiModelProperty("访问组织")
  private String organizationName;

  @ApiModelProperty("访问文件名称")
  private String fineName;

  @ApiModelProperty("访问时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date visitTime;

  public FilterDataAccessLogDto() {
  }

  public FilterDataAccessLogDto(String userName, String organizationName, String fineName, Date visitTime) {
    this.userName = userName;
    this.organizationName = organizationName;
    this.fineName = fineName;
    this.visitTime = visitTime;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public String getFineName() {
    return fineName;
  }

  public void setFineName(String fineName) {
    this.fineName = fineName;
  }

  public Date getVisitTime() {
    return visitTime;
  }

  public void setVisitTime(Date visitTime) {
    this.visitTime = visitTime;
  }
}
