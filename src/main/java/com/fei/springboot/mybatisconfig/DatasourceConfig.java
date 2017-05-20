package com.fei.springboot.mybatisconfig;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DatasourceConfig {
	private Logger logger = LoggerFactory.getLogger(DatasourceConfig.class);
	
    @Value("${spring.datasource.url}")
    private String dbUrl;
    
    @Value("${spring.datasource.type}")
    private String dbType;
    
    @Value("${spring.datasource.username}")
    private String username;
    
    @Value("${spring.datasource.password}")
    private String password;
    
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    
    @Value("${spring.datasource.filters}")
    private String filters;
    
    
	
    @Bean(name="dataSource",destroyMethod = "close", initMethod="init")
    @Primary
    public DataSource dataSource(){  
        DruidDataSource datasource = new DruidDataSource();  
        try {  
	        datasource.setUrl(this.dbUrl);  
	        datasource.setDbType(dbType);
	        datasource.setUsername(username);  
	        datasource.setPassword(password);  
	        datasource.setDriverClassName(driverClassName);  
	        datasource.setInitialSize(initialSize);  
	        datasource.setMinIdle(minIdle);  
	        datasource.setMaxActive(maxActive);  
	        datasource.setMaxWait(maxWait);  
	        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
	        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
	        datasource.setValidationQuery(validationQuery);  
	        datasource.setTestWhileIdle(testWhileIdle);  
	        datasource.setTestOnBorrow(testOnBorrow);  
	        datasource.setTestOnReturn(testOnReturn);  
	        datasource.setPoolPreparedStatements(poolPreparedStatements);  
            datasource.setFilters(filters);  
        } catch (SQLException e) {  
            logger.error("druid configuration initialization filter", e);  
        }  
        return datasource;  
    }
}