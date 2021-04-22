package com.yunli.bigdata.dsep.foundation.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author : zhengyangyong
 */
public class JsonUtil {
  private static final ObjectMapper MAPPER = new ObjectMapper();

  private static final ObjectMapper PRETTY_MAPPER = new ObjectMapper();

  static {
    PRETTY_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    PRETTY_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public static String writeValueAsString(Object obj) {
    try {
      return MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      return obj.toString();
    }
  }


  public static String writeValueAsPrettyString(Object obj) {
    try {
      return PRETTY_MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      return obj.toString();
    }
  }

  public static <T> T readValue(String json, Class<T> type) {
    try {
      return MAPPER.readValue(json, type);
    } catch (Exception e) {
      return null;
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> List<T> readListValue(String json, Class<T> type) {
    try {
      JavaType javaType = getCollectionType(ArrayList.class, type);
      return (List<T>) MAPPER.readValue(json, javaType);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
    return MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
  }
}
