package com.yunli.web.config;

import com.mysql.jdbc.Driver;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Data
@ConfigurationProperties(prefix = "hue.datasource")
public class HueConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
