package com.yunli.bigdata.dsep.service.common.constant;

/**
 * @author wei
 */
public enum RoleOrGroupPrivilegeCode {
  /**
   * 菜单权限
   */
  MenuPrivilege("menuPrivilege"),
  /**
   * 功能权限
   */
  AppPrivilege("appPrivilege"),
  /**
   * 数据表权限
   */
  DataPrivilege("dataPrivilege"),

  /**
   * 文件夹权限
   */
  DocumentPrivilege("documentPrivilege"),

  /**
   * 实时数据信道权限
   */
  TopicPrivilege("topicPrivilege"),

  /**
   * 数据表同步作业权限
   */
  JobPrivilege("jobPrivilege"),
  /**
   * 文件夹同步作业权限
   */
  JobDocumentSynchronousPrivilege("jobDocumentSynchronousPrivilege"),
  /**
   * 实时数据信道同步作业权限
   */
  JobTopicSynchronousPrivilege("jobTopicSynchronousPrivilege"),
  /**
   * 实时数据信道同步作业权限
   */
  JobTopicDevelopmentPrivilege("jobTopicDevelopmentPrivilege"),
  /**
   * 数据源权限
   */
  DataSourcePrivilege("dataSourcePrivilege");

  private String name;

  RoleOrGroupPrivilegeCode(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static boolean contains(String name) {
    for (RoleOrGroupPrivilegeCode status : RoleOrGroupPrivilegeCode.values()) {
      if (status.name.equals(name)) {
        return true;
      }
    }
    return false;
  }
}
