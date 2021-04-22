package com.yunli.bigdata.dsep.service.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author zhengyangyong
 * 加载本地配置文件
 */
public class PropertiesConfigurationLoader implements ConfigurationLoader {
  private final Map<String, String> properties;

  @Autowired
  public PropertiesConfigurationLoader(ApplicationContext context) {
    properties = new HashMap<>();
    String propertiesFile = "/application.properties";
    if (context != null) {
      String[] profiles = context.getEnvironment().getActiveProfiles();
      if (profiles.length != 0) {
        propertiesFile = String.format("/application-%s.properties", profiles[0]);
      }
    }

    Resource resource = new ClassPathResource(propertiesFile);
    try {
      Properties fileProperties = PropertiesLoaderUtils
          .loadProperties(new EncodedResource(resource, StandardCharsets.UTF_8));
      fileProperties.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    } catch (IOException ignored) {
    }

    try {
      Properties fileProperties = new Properties();
      fileProperties.load(new FileInputStream(System.getProperty("user.dir") + propertiesFile));
      fileProperties.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    } catch (Exception ignored) {
    }

    //加载系统属性
    System.getProperties().forEach((key, value) -> properties.put(key.toString(), value.toString()));

    //加载环境变量
    System.getenv().forEach(properties::put);
  }

  @Override
  public Object get(String key, Object defaultValue) {
    if (properties == null) {
      return defaultValue;
    }
    return properties.getOrDefault(key, defaultValue == null ? null : defaultValue.toString());
  }

  @Override
  public Map<String, Object> getAll() {
    return properties.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
  }
}
