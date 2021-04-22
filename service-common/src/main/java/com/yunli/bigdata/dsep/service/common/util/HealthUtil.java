package com.yunli.bigdata.dsep.service.common.util;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.yunli.bigdata.dsep.foundation.DynamicConfigurationItem;
import com.yunli.bigdata.dsep.foundation.HealthInformation;
import com.yunli.bigdata.dsep.foundation.util.InvocationUtil;

/**
 * @author : zhengyangyong
 */
public class HealthUtil {
  private static final RestTemplate TEMPLATE = new RestTemplate();

  private static final ParameterizedTypeReference<DynamicConfigurationItem[]> TYPE_REF =
      new ParameterizedTypeReference<DynamicConfigurationItem[]>() {
      };

  public static ResponseEntity<Void> report(String status, String detail) {
    String uri = InvocationUtil.getBaseUri() + "/health/" + status;
    return TEMPLATE.postForEntity(uri, detail, Void.class);
  }

  public static ResponseEntity<HealthInformation> query() {
    String uri = InvocationUtil.getBaseUri() + "/health";
    return TEMPLATE.getForEntity(uri, HealthInformation.class);
  }
}
