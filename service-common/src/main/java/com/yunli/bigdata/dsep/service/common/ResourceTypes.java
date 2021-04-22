package com.yunli.bigdata.dsep.service.common;

import com.yunli.bigdata.dsep.service.common.dto.audit.CodeNameDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangpengfei
 * @date 2019-06-27
 */
public class ResourceTypes {
  /**
   * ALL means everything, if ALL specified, resource id will be ignored.
   */
  public static final String ALL = "*";

  /**
   * 目录及目录树
   */
  public static final String DATA_TAG = "data-tag";

  /**
   * 数据表
   */
  public static final String DATA = "data";

  /**
   * 文件夹
   */
  public static final String DOCUMENT = "document";

  public static final String FILE = "file";

  /**
   * 实时数据信道
   */
  public static final String TOPIC = "topic";

  /**
   * 资源标签
   */
  public static final String LABEL = "label";

  /**
   * 组织
   */
  public static final String ORGANIZATION = "organization";

  /**
   * 组
   */
  public static final String GROUP = "group";

  /**
   * 角色
   */
  public static final String ROLE = "role";

  /**
   * 用户
   */
  public static final String USER = "user";

  public static final String STORAGE = "storage";

  /**
   * 审计
   */
  public static final String AUDIT = "audit";

  public static final String STATISTICS = "statistics";

  /**
   * 数据表同步作业
   */
  public static final String JOB = "job";

  /**
   * 文件夹同步作业
   */
  public static final String JOB_DOCUMENT_SYNCHRONOUS = "job-document-synchronous";

  /**
   * 实时数据信道同步作业
   */
  public static final String JOB_TOPIC_SYNCHRONOUS = "job-topic-synchronous";

  /**
   * 实时数据开发
   */
  public static final String JOB_TOPIC_DEVELOPMENT = "job-topic-development";


  /**
   * 数据源
   */
  public static final String JOB_DATASOURCE = "job-datasource";

  /**
   * 菜单
   */
  public static final String MENU = "menu";

  private static final List<CodeNameDto> TYPES_LIST = new ArrayList<CodeNameDto>() {{
    add(new CodeNameDto(DATA_TAG, "数据目录"));
    add(new CodeNameDto(DATA, "数据表"));
    add(new CodeNameDto(DOCUMENT, "文件夹"));
    add(new CodeNameDto(TOPIC, "实时数据信道"));
    add(new CodeNameDto(LABEL, "资源标签"));
    add(new CodeNameDto(JOB_TOPIC_SYNCHRONOUS, "实时数据同步作业"));
    add(new CodeNameDto(JOB_TOPIC_DEVELOPMENT, "实时数据开发"));
    add(new CodeNameDto(JOB, "数据作业"));
    add(new CodeNameDto(JOB_DATASOURCE, "数据源"));
    add(new CodeNameDto(AUDIT, "审计"));
    add(new CodeNameDto(ROLE, "角色"));
    add(new CodeNameDto(GROUP, "组"));
    add(new CodeNameDto(USER, "用户"));
  }};

  private static final Map<String, String> TYPES = new HashMap<String, String>() {
    {
      put(DATA_TAG, "数据目录");
      put(DATA, "数据表");
      put(DOCUMENT, "文件夹");
      put(LABEL, "资源标签");
      put(TOPIC, "实时数据信道");
      put(JOB, "数据表同步作业");
      put(JOB_DOCUMENT_SYNCHRONOUS, "文件夹同步作业");
      put(JOB_TOPIC_SYNCHRONOUS, "实时数据同步作业");
      put(JOB_TOPIC_DEVELOPMENT, "实时数据开发");
      put(JOB_DATASOURCE, "数据源");
      put(AUDIT, "审计");
      put(ROLE, "角色");
      put(GROUP, "组");
      put(USER, "用户");
      put(MENU, "菜单");
    }
  };

  public static boolean contains(String type) {
    if (StringUtils.isEmpty(type)) {
      return false;
    }
    return type.equals(ALL) || TYPES.containsKey(type);
  }

  public static boolean containsName(String type) {
    if (StringUtils.isEmpty(type)) {
      return false;
    }
    return type.equals(ALL) || TYPES.containsValue(type);
  }

  public static String getResourceTypeName(String type) {
    return TYPES.getOrDefault(type, null);
  }

  public static List<CodeNameDto> getResourceTypes() {
    return TYPES_LIST;
  }
}
