package com.smile.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

//配置SessionFatory
@SpringBootConfiguration
public class SessionFactoryConfiguration {

    @Value("${mybatis.type-aliases-package}")
    private String mapperXMLConfigPath;
    @Value("${mybatis.mapper-locations}")
    private String mapperPackagePath;
    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //String packageXMLConfigPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPackagePath;
        // 设置 mapper 对应的 XML 文件的路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperPackagePath));
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置 mapper 接口所在的包
        sqlSessionFactoryBean.setTypeAliasesPackage(mapperXMLConfigPath);
        return sqlSessionFactoryBean;
    }
}
