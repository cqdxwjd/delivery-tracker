package com.yunli.bigdata.dsep.service.common.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author : zhangws
 */
@ApiModel(description = "用户概要")
public class UserSummaryDto implements Serializable {
  @ApiModelProperty("用户Id")
  private String id;

  @ApiModelProperty("用户名")
  private String name;

  @ApiModelProperty("秘钥")
  private String secretKey;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  public UserSummaryDto() {
  }

  public UserSummaryDto(String id, String name, String secretKey) {
    this.id = id;
    this.name = name;
    this.secretKey = secretKey;
  }
}
