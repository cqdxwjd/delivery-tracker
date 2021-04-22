package com.yunli.bigdata.dsep.foundation.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author zhengyangyong
 */
public class SpiUtil {
  public static <T> List<T> loadAllService(Class<T> serviceType) {
    List<T> services = new ArrayList<>();
    ServiceLoader<T> serviceLoader = ServiceLoader.load(serviceType);
    serviceLoader.forEach(services::add);
    for (int idx = 0; idx < services.size(); idx++) {
      T service = services.get(idx);
    }
    return services;
  }
}
