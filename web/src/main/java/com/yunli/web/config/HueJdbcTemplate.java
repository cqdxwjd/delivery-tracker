package com.yunli.web.config;

import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class HueJdbcTemplate {
    private HueConfig hueConfig;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public HueJdbcTemplate(HueConfig hueConfig) {
        this.hueConfig = hueConfig;
    }

    public DataSource getDataSource() {
        try {
            if (null == dataSource) {
                dataSource = new SimpleDriverDataSource(new Driver(),
                        hueConfig.getUrl(), hueConfig.getUsername(), hueConfig.getPassword());
            }
            return dataSource;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public JdbcTemplate getHueJdbcTemplate() {
        if (null == jdbcTemplate) {
            jdbcTemplate = new JdbcTemplate(getDataSource());
            return jdbcTemplate;
        }
        return jdbcTemplate;
    }
}
