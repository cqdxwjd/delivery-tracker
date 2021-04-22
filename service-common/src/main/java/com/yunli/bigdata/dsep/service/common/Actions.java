package com.yunli.bigdata.dsep.service.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.yunli.bigdata.dsep.service.common.dto.audit.CodeNameDto;

/**
 * @author wangpengfei
 * @date 2019-06-27
 */
public class Actions {
  /**
   * ALL means everything, if ALL specified, user who has the privilege is the responsible of the resource.
   */
  public static final String ALL = "*";

  /**
   * 登录
   */
  public static final String LOGIN = "login";

  /**
   * 新建
   */
  public static final String CREATE = "create";

  /**
   * 删除
   */
  public static final String DELETE = "delete";

  /**
   * 修改
   */
  public static final String MODIFY = "modify";

  /**
   * 变更
   */
  public static final String CHANGE = "change";

  /**
   * 分配权限
   */
  public static final String GRANT = "grant";

  /**
   * 取消授权
   */
  public static final String REVOKE = "revoke";


  /**
   * 数据访问
   */
  public static final String SUBSCRIBE = "subscribe";

  /**
   * 数据API访问
   */
  public static final String SUBSCRIBE_API1 = "subscribe-api";

  /**
   * 数据库表导出访问
   */
  public static final String SUBSCRIBE_JOB = "subscribe-job";

  /**
   * 数据事件总线订阅
   */
  public static final String SUBSCRIBE_EVENT_BUS = "subscribe-event-bus";

  /**
   * 查询/读取
   */
  public static final String READ = "read";

  /**
   * 发布
   */
  public static final String BE_PUBLISHED = "be_published";

  /**
   * 下架
   */
  public static final String BE_UNPUBLISHED = "be_unpublished";


  /**
   * 申请
   */
  public static final String APPLICATION = "application";

  /**
   * 审批
   */
  public static final String APPROVAL = "approval";

  /**
   * 授权访问用户
   */
  public static final String APPROVAL_SUBSCRIBE = "approval-subscribe";

  /**
   * 启停
   */
  public static final String START_STOP = "start-stop";

  /**
   * 关联目录
   */
  public static final String ASSOCIATED_TAG = "associated-tag";

  /**
   * 补入数据
   */
  public static final String SUPPLEMENTARY_DATA = "supplementary-data";

  private static final List<CodeNameDto> ACTIONS_LIST = new ArrayList<CodeNameDto>() {{
    add(new CodeNameDto(CREATE, "新建"));
    add(new CodeNameDto(DELETE, "删除"));
    add(new CodeNameDto(MODIFY, "修改"));
    add(new CodeNameDto(CHANGE, "变更"));

//      add(new CodeNameDto(READ, "查看"));
    add(new CodeNameDto(GRANT, "分配权限"));
    add(new CodeNameDto(REVOKE, "取消授权"));
    add(new CodeNameDto(SUBSCRIBE, "数据访问"));
    add(new CodeNameDto(BE_PUBLISHED, "发布"));
    add(new CodeNameDto(BE_UNPUBLISHED, "下架"));
    add(new CodeNameDto(APPLICATION, "申请"));
    add(new CodeNameDto(APPROVAL, "审批"));
    add(new CodeNameDto(APPROVAL_SUBSCRIBE, "授权访问用户"));
    add(new CodeNameDto(ASSOCIATED_TAG, "关联目录"));
    add(new CodeNameDto(START_STOP, "启停"));
    add(new CodeNameDto(LOGIN, "登录"));
  }};


  private static final Map<String, String> ACTIONS = new HashMap<String, String>() {
    {
      put(CREATE, "新建");
      put(DELETE, "删除");
      put(MODIFY, "修改");
      put(CHANGE, "变更");
      put(READ, "查看");
      put(GRANT, "分配权限");
      put(REVOKE, "取消授权");
      put(SUBSCRIBE, "数据访问");
      put(BE_PUBLISHED, "发布");
      put(BE_UNPUBLISHED, "下架");
      put(APPLICATION, "申请");
      put(APPROVAL, "审批");
      put(APPROVAL_SUBSCRIBE, "授权访问用户");
      put(ASSOCIATED_TAG, "关联目录");
      put(SUPPLEMENTARY_DATA, "补入数据");
      put(START_STOP, "启停");
      put(LOGIN, "登录");
    }
  };

  public static boolean contains(String action) {
    if (StringUtils.isEmpty(action)) {
      return false;
    }
    return action.equals(ALL) || ACTIONS.containsKey(action);
  }

  public static boolean containsName(String action) {
    if (StringUtils.isEmpty(action)) {
      return false;
    }
    return action.equals(ALL) || ACTIONS.containsValue(action);
  }

  public static String getActionName(String action) {
    return ACTIONS.getOrDefault(action, null);
  }

  public static Set<String> getActionCodes() {
    return new HashSet<>(ACTIONS.keySet());
  }

  public static List<CodeNameDto> getActions() {
    return ACTIONS_LIST;
  }
}
