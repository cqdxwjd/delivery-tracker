package com.yunli.bigdata.dsep.service.common.constant;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 周期类型
 *
 * @author zhangws
 */
public class CycleType {

  public static final String MIN = "分钟";

  public static final String HOUR = "小时";

  public static final String DAY = "日";

  public static final String WEEK = "周";

  public static final String MONTH = "月";

  public static final String ONLY_ONE = "仅一次";

  private CycleType() {
  }

  /**
   * 返回名称列表（会创建新的实例）
   */
  public static List<String> getNames() {
    List<String> types = new ArrayList<>(6);
    types.add(MIN);
    types.add(HOUR);
    types.add(DAY);
    types.add(WEEK);
    types.add(MONTH);
    types.add(ONLY_ONE);
    return types;
  }

  public static String toStr() {
    return "分钟,小时,日,周,月,仅一次";
  }

  public static boolean contains(String name) {
    if (StringUtils.isEmpty(name)) {
      return false;
    }
    switch (name) {
      case MIN:
      case HOUR:
      case DAY:
      case WEEK:
      case MONTH:
      case ONLY_ONE:
        return true;
      default:
        return false;
    }
  }
}
