package com.qing.fan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author QingFan 2022/9/26
 * @version 1.0.0
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "securityDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.security")
    public DataSource dataSource () {
        return DataSourceBuilder.create().build();
    }
}
