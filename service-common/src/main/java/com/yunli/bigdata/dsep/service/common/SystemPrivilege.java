package com.yunli.bigdata.dsep.service.common;

/**
 * @author wangpengfei
 * @date 2019-06-26
 */
public enum SystemPrivilege {
  /**
   *
   */
  CREATE_GROUP(ResourceTypes.GROUP, Actions.CREATE),
  DELETE_GROUP(ResourceTypes.GROUP, Actions.DELETE),
  /**
   * 主说，要粗。
   */
  MODIFY_GROUP(ResourceTypes.GROUP, Actions.MODIFY),
  CREATE_ROLE(ResourceTypes.ROLE, Actions.CREATE),
  DELETE_ROLE(ResourceTypes.ROLE, Actions.DELETE),
  MODIFY_ROLE(ResourceTypes.ROLE, Actions.MODIFY),
  CREATE_ORGANIZATION(ResourceTypes.ORGANIZATION, Actions.CREATE),
  DELETE_ORGANIZATION(ResourceTypes.ORGANIZATION, Actions.DELETE),
  MODIFY_ORGANIZATION(ResourceTypes.ORGANIZATION, Actions.MODIFY),

  /**
   * 授权
   */
  GRANT_GROUP(ResourceTypes.GROUP, Actions.GRANT),
  GRANT_ROLE(ResourceTypes.ROLE, Actions.GRANT);

  private String resource;

  private String action;

  public static final long ALL_OF_RESOURCES = -1;

  SystemPrivilege(String resource, String action) {
    this.resource = resource;
    this.action = action;
  }

  public String getResource() {
    return resource;
  }

  public String getAction() {
    return action;
  }

  public long getResourceId() {
    return ALL_OF_RESOURCES;
  }

  @Override
  public String toString() {
    return String.format("%s.%s", resource, action);
  }
}
