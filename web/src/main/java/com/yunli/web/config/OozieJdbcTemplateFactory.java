package com.yunli.web.config;

import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class OozieJdbcTemplateFactory {
    private OozieConfig oozieConfig;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public OozieJdbcTemplateFactory(OozieConfig oozieConfig) {
        this.oozieConfig = oozieConfig;
    }

    public DataSource getDataSource() {
        try {
            if (null == dataSource) {
                dataSource = new SimpleDriverDataSource(new Driver(),
                        oozieConfig.getUrl(), oozieConfig.getUsername(), oozieConfig.getPassword());
            }
            return dataSource;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public JdbcTemplate getJdbcTemplate() {
        if (null == jdbcTemplate) {
            jdbcTemplate = new JdbcTemplate(getDataSource());
            return jdbcTemplate;
        }
        return jdbcTemplate;
    }
}
