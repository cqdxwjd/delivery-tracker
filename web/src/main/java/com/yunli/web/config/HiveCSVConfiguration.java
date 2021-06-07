package com.yunli.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangjingdong
 * @date 2021/6/7 10:27
 * @Copyright © 云粒智慧 2018
 */
@Data
@ConfigurationProperties(prefix = "hive-csv")
@Configuration
public class HiveCSVConfiguration {
    private String metastoreUri;
    private String database;
    private String readerParallelism;
    private String writerPath;
}
