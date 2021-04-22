package com.yunli.bigdata.dsep.service.common.constant;

import java.util.Arrays;
import java.util.List;

/**
 * TOPIC的一些基础配置
 * @author david
 */
public class TopicSetting {

  /**
   * topic分组的统一前缀，模式是g_****（topic名称）
   */
  public static final String TOPIC_GROUP_PREFIX = "g_";


  /**
   * 业务告警队列（可用于规则计算不通过）
   */
  public static final String SYS_BUSI_WARN_TOPIC = "sys_event_YnVzaW5lc3N3YXJuZm9ydXNlcg_";

  /**
   * 系统预留告警队列
   */
  public static final String SYS_WARN_TOPIC = "sys_event_d2Fybm9mc3lzdGVtZm9yeXVubGk_";

  /**
   * 管理控制队列
   */
  public static final String SYS_OPERATE_TOPIC = "sys_event_b3BlcmF0ZXRvcGljb2Zjb250cm9sbGVy_";

  /**
   * 系统消息的默认消费队列
   */
  public static final String GROUP_SYSTEM = "group_system";

  public static final List<String> LIST_COLUMN_TYPE = Arrays.asList("int,long,string,float,double,boolean,date".split(","));
}
