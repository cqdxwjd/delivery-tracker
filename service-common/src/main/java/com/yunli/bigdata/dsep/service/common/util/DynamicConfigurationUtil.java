package com.yunli.bigdata.dsep.service.common.util;

import com.yunli.bigdata.dsep.foundation.DynamicConfigurationItem;
import com.yunli.bigdata.dsep.foundation.util.InvocationUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author : zhengyangyong
 */
public class DynamicConfigurationUtil {
  private static final RestTemplate TEMPLATE = new RestTemplate();

  private static final ParameterizedTypeReference<DynamicConfigurationItem[]> TYPE_REF =
      new ParameterizedTypeReference<DynamicConfigurationItem[]>() {
      };

  public static ResponseEntity<String> get(String key) {
    String uri = InvocationUtil.getBaseUri() + "/configurations/" + key;
    return TEMPLATE.getForEntity(uri, String.class);
  }

  public static ResponseEntity<DynamicConfigurationItem[]> getAll() {
    String uri = InvocationUtil.getBaseUri() + "/configurations";
    return TEMPLATE.exchange(uri, HttpMethod.GET, null, DynamicConfigurationUtil.TYPE_REF);
  }

  public static ResponseEntity<Boolean> subscribe(int port) {
    String callbackUri = "http://127.0.0.1:" + port + "/configurations/events";
    return subscribe(callbackUri);
  }

  public static ResponseEntity<Boolean> subscribe(String callbackUri) {
    String uri = InvocationUtil.getBaseUri() + "/configurations/subscribers";
    return TEMPLATE.postForEntity(uri, callbackUri, Boolean.class);
  }

  public static ResponseEntity<Void> unsubscribe(int port) {
    String callbackUri = "http://127.0.0.1:" + port + "/configurations/events";
    return unsubscribe(callbackUri);
  }

  public static ResponseEntity<Void> unsubscribe(String callbackUri) {
    String uri = InvocationUtil.getBaseUri() + "/configurations/subscribers";
    return TEMPLATE.exchange(uri, HttpMethod.DELETE, new HttpEntity<>(callbackUri), Void.class);
  }
}
