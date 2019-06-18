package com.example.springbootjpa.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 14:57 2019/5/15
 */
@Configuration
public class MyDataSourceConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String className;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    @Primary
    public DataSource dataSource(){
        DruidDataSource source=new DruidDataSource();
         source.setUrl(this.url);
         source.setUsername(this.userName);
        source.setPassword(this.password);
        source.setDriverClassName(this.className);
        return source;
    }
}