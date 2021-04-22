package com.yunli.bigdata.dsep.foundation.util;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author zhengyangyong
 */
public class ScheduledExecutorUtil {
  public static ScheduledExecutorService create(String executorName, int corePoolSize) {
    return new ScheduledThreadPoolExecutor(corePoolSize, r -> {
      Thread t = new Thread(r, executorName);
      t.setDaemon(true);
      return t;
    });
  }
}
