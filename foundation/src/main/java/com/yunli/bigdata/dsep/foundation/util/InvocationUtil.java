package com.yunli.bigdata.dsep.foundation.util;

import org.springframework.util.StringUtils;

import com.yunli.bigdata.dsep.foundation.SystemConstants;
import com.yunli.bigdata.dsep.foundation.SystemProperties;

/**
 * @author : zhengyangyong
 */
public class InvocationUtil {
  public static String getServiceUri(String serviceName, String version, String path) {
    return getServiceUri(serviceName, version, path, false);
  }

  public static String getServiceUri(String serviceName, String version, String path, boolean isSsl) {
    String name = serviceName.startsWith(SystemConstants.SERVICE_PATH_PREFIX) ? serviceName :
        SystemConstants.SERVICE_PATH_PREFIX + serviceName;
    return getBaseUri(isSsl) + "/" + name + "/" + version + (path.startsWith("/") ? path : ("/" + path));
  }

  public static String getBaseUri() {
    return getBaseUri(false);
  }

  public static String getBaseUri(boolean isSsl) {
    String routerAddress = SystemProperties.INSTANCE.get("router.address");
    if (StringUtils.isEmpty(routerAddress)) {
      String port = StringUtils.isEmpty(SystemProperties.INSTANCE.get("agent.port")) ? "54321"
          : SystemProperties.INSTANCE.get("agent.port");

      return (isSsl ? "https://127.0.0.1:" : "http://127.0.0.1:") + port;
    } else {
      return (isSsl ? "https://" : "http://") + routerAddress;
    }
  }

  public static String buildPath(String... parts) {
    if (parts.length == 1) {
      return parts[0];
    }
    StringBuilder uri = new StringBuilder(parts[0]);
    for (int i = 1; i < parts.length; i++) {
      if (parts[i - 1].endsWith("/")) {
        uri.append(parts[i].startsWith("/") ? parts[i].substring(1) : parts[i]);
      } else {
        uri.append(parts[i].startsWith("/") ? parts[i] : "/" + parts[i]);
      }
    }
    return uri.toString();
  }

  public static String getBaseUriNoSsl(String endpoint) {
    return getBaseUri(endpoint, false);
  }

  public static String getBaseUri(String endpoint, boolean isSsl) {
    if (isSsl) {
      return "https://" + endpoint;
    } else {
      return "http://" + endpoint;
    }
  }
}
