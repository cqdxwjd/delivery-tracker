package com.yunli.web.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "data-mid-platform")
@Configuration
public class DataPlatformConfiguration {
    private Integer version;
    private String userId;
    private String privateKey;
    private String address;
    private String oozieUrl;
}
