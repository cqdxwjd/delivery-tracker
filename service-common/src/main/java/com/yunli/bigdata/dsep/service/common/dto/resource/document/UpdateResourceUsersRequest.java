package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wei
 */
public class UpdateResourceUsersRequest implements Serializable {

  @ApiModelProperty("用户ID列表")
  private List<String> userIds;

  public List<String> getUserIds() {
    return userIds;
  }

  public void setUserIds(List<String> userIds) {
    this.userIds = userIds;
  }
}
