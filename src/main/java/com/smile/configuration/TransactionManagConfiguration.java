package com.smile.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//配置TransactionManagement
@SpringBootConfiguration
public class TransactionManagConfiguration {

    @Autowired
    private DataSource dataSource;

    public PlatformTransactionManager annotationDrivenTransactionManagement(){
        return new DataSourceTransactionManager(dataSource);
    }
}
