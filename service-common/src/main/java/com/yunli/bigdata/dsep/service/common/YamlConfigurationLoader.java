package com.yunli.bigdata.dsep.service.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

public class YamlConfigurationLoader implements ConfigurationLoader {
  private static final Logger LOGGER = LoggerFactory.getLogger(YamlConfigurationLoader.class);

  private final Map<String, Object> properties;

  public YamlConfigurationLoader(ApplicationContext context) {
    properties = new HashMap<>();

    //加载本地配置
    String yamlFile = "/application.yml";
    if (context != null) {
      String[] profiles = context.getEnvironment().getActiveProfiles();
      if (profiles.length != 0) {
        yamlFile = String.format("/application-%s.yml", profiles[0]);
      }
    }

    Resource resource = new ClassPathResource(yamlFile);
    Yaml yaml = new Yaml();
    try {
      Iterable<Object> configurations = yaml.loadAll(resource.getInputStream());
      List<Map<String, Object>> processedConfigurations = new ArrayList<>();
      for (Object configuration : configurations) {
        processedConfigurations.add(retrieveItems("", (Map<String, Object>) configuration));
      }
      for (Map<String, Object> processedConfiguration : processedConfigurations) {
        if (!processedConfiguration.containsKey("spring.profiles")) {
          properties.putAll(processedConfiguration);
        }
      }
    } catch (IOException ignored) {
    }

    yaml = new Yaml();
    try (FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + yamlFile)) {
      Iterable<Object> configurations = yaml.loadAll(stream);
      List<Map<String, Object>> processedConfigurations = new ArrayList<>();
      for (Object configuration : configurations) {
        processedConfigurations.add(retrieveItems("", (Map<String, Object>) configuration));
      }
      for (Map<String, Object> processedConfiguration : processedConfigurations) {
        if (!processedConfiguration.containsKey("spring.profiles")) {
          properties.putAll(processedConfiguration);
        }
      }
    } catch (Exception ignored) {
    }

    //加载系统属性
    System.getProperties().forEach((key, value) -> properties.put(key.toString(), value.toString()));

    //加载环境变量
    System.getenv().forEach(properties::put);
  }

  private static Map<String, Object> retrieveItems(String prefix, Map<String, Object> propertieMap) {
    Map<String, Object> result = new LinkedHashMap<>();
    if (!prefix.isEmpty()) {
      prefix += ".";
    }
    for (Entry<String, Object> entry : propertieMap.entrySet()) {
      if (entry.getValue() instanceof Map) {
        result.putAll(retrieveItems(prefix + entry.getKey(), (Map<String, Object>) entry.getValue()));
      } else {
        String key = prefix + entry.getKey();
        result.put(key, entry.getValue());
      }
    }
    return result;
  }

  @Override
  public Object get(String key, Object defaultValue) {
    if (properties == null) {
      return defaultValue;
    }
    return properties.getOrDefault(key, defaultValue);
  }

  @Override
  public Map<String, Object> getAll() {
    return properties.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
  }
}
