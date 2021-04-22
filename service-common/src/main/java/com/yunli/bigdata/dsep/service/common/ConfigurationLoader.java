package com.yunli.bigdata.dsep.service.common;

import java.util.Map;

/**
 * @author zhengyangyong
 */
public interface ConfigurationLoader {
  /**
   * 根据Key获取配置项的Value
   * @param key Key
   * @param defaultValue 默认值
   * @return Value
   */
  Object get(String key, Object defaultValue);

  /**
   * 查询所有配置项
   * @return 配置项结果
   */
  Map<String, Object> getAll();
}
