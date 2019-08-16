package com.wuqy.vdslearn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VdsLearnApplicationTests {

    @Test
    public void getUserList() throws Exception{
        Resource resource0 = new ClassPathResource("dataService/**.xml");
        ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        Resource[] resource = resourceLoader.getResources("classpath:dataService/**.xml");
        for (Resource resource1 : resource) {
            InputStream inputStream = resource1.getInputStream();
        }

    }

}
