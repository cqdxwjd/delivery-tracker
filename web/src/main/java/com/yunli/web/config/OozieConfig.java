package com.yunli.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "oozie.datasource")
public class OozieConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
