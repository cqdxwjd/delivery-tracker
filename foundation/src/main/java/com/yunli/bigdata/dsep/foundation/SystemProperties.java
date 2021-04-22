package com.yunli.bigdata.dsep.foundation;

import java.util.Properties;

import org.springframework.util.StringUtils;

/**
 * @author : zhengyangyong
 */
public class SystemProperties {
  public static final SystemProperties INSTANCE = new SystemProperties();

  private final Properties properties;

  private SystemProperties() {
    this.properties = System.getProperties();
  }

  public String get(String key) {
    return this.properties.getProperty(key);
  }

  public void set(String key, String value) {
    this.properties.setProperty(key, value);
  }

  public boolean isDynamicConfigurationEnabled() {
    return !StringUtils.isEmpty(properties.getProperty("spring.cloud.nacos.config.server-addr"));
  }

  public void enableDiscoveryLocator() {
    if (!StringUtils.isEmpty(properties.getProperty("spring.cloud.nacos.discovery.server-addr"))) {
      properties.setProperty("spring.cloud.gateway.discovery.locator.enabled", "true");
      properties.setProperty("spring.cloud.gateway.discovery.locator.lowerCaseServiceId", "true");
    } else {
      properties.setProperty("spring.cloud.nacos.discovery.enabled", "false");
    }
  }
}
