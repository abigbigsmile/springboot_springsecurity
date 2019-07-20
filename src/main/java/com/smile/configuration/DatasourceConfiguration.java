package com.smile.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

//配置数据源
@SpringBootConfiguration
public class DatasourceConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String jabcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUsername;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    @Bean
    public DataSource createDataSource() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jabcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setMaxPoolSize(10);
        dataSource.setMinPoolSize(2);
        dataSource.setInitialPoolSize(2);
        dataSource.setMaxIdleTime(300);
        dataSource.setAcquireIncrement(2);
        return dataSource;
    }

}
