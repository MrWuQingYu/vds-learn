package com.wuqy.vdslearn.config;/**
 * @author ：wuqy
 * @date ：Created in 2019/8/15 10:39
 * @description：
 * @modified By：
 * @version：1.0
 */

import com.tydic.uda.service.factory.XmlDataServiceFactory;
import com.tydic.vds.backend.jdbc.JdbcDatabase;
import com.tydic.vds.spring.CommonPartition;
import com.tydic.vds.spring.Environment;
import com.tydic.vds.spring.ListScanner;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author ：wuqy
 * @date ：Created in 2019/8/15 10:39
 * @description：
 * @modified By：
 * @version：1.0
 */
@Configuration
public class VdsConfig {

    /**
     * 扫描数据库操作映射文件
     */
    private static final String DATA_SERVICE_PATH = "classpath:dataService/**.xml";


    //@ConditionalOnBean(DataSource.class)
    @Bean
    public JdbcDatabase henandatareport(DataSource dataSource) {
        JdbcDatabase jdbcDatabase = new JdbcDatabase();
        jdbcDatabase.setId(1);
        jdbcDatabase.setDataSource(dataSource);
        return jdbcDatabase;
    }

    @Bean
    public AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor() {
        return new AutowiredAnnotationBeanPostProcessor();
    }

    @Bean
    public ListScanner listScanner() {
        return new ListScanner();
    }

    //@ConditionalOnBean(value = {JdbcDatabase.class,ListScanner.class})
    @Bean
    public Environment env(JdbcDatabase henandatareport, ListScanner listScanner) {
        Environment environment = new Environment();
        environment.setUrl("jdbc:vds:local://classpath?sid=billing");
        environment.setCompatible("V2");
        environment.setBackends(Arrays.asList(henandatareport));
        environment.setTableList(listScanner.getTableList());
        return environment;
    }

    //@ConditionalOnBean(value = {JdbcDatabase.class})
    @Bean
    public CommonPartition commonPartition(JdbcDatabase henandatareport) {
        CommonPartition commonPartition = new CommonPartition();
        commonPartition.setDatabase(henandatareport);
        return commonPartition;
    }

    //@ConditionalOnBean(value = {DataSource.class})
    @Bean
    public XmlDataServiceFactory xmlDataServiceFactory(DataSource dataSource) throws Exception {
        XmlDataServiceFactory xmlDataServiceFactory = new XmlDataServiceFactory();
        xmlDataServiceFactory.setDataSource(dataSource);
        // 加载通配符资源
        ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        Resource[] resource = resourceLoader.getResources(DATA_SERVICE_PATH);
        xmlDataServiceFactory.setServiceLocations(resource);
        return xmlDataServiceFactory;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource vdsDataSource) {
        return new DataSourceTransactionManager(vdsDataSource);
    }
}
