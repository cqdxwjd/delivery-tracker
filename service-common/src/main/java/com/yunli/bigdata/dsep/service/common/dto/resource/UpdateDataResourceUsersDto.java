package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;
import java.util.List;

/**
 * @author wei
 */
public class UpdateDataResourceUsersDto implements Serializable {
  List<String> userIds;

  public List<String> getUserIds() {
    return userIds;
  }

  public void setUserIds(List<String> userIds) {
    this.userIds = userIds;
  }
}
