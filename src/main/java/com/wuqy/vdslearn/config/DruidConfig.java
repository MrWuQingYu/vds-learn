package com.wuqy.vdslearn.config;/**
 * @author ：wuqy
 * @date ：Created in 2019/8/15 10:40
 * @description：
 * @modified By：
 * @version：1.0
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author ：wuqy
 * @date ：Created in 2019/8/15 10:40
 * @description：
 * @modified By：
 * @version：1.0
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public DataSource vdsDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:vds:local://classpath?sid=billing");
        druidDataSource.setDriverClassName("com.tydic.vds.jdbc.VdsDriver");
        druidDataSource.setUsername("specialized");
        druidDataSource.setPassword("specialized");
        return druidDataSource;
    }

}
