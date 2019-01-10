package com.example.springbootdemo;

import com.example.cache.bean.AppCache;
import com.example.cache.dao.AppCacheDao;
import com.example.person.bean.Dog;
import com.example.person.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ioc;

    @Autowired
    private Dog dog;

    @Autowired
    DataSource dataSource;

    @Autowired
    private AppCacheDao appCacheDao;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void config() {
        boolean success = ioc.containsBean("personService");
        logger.trace("trace");
        logger.debug("debug");
        logger.info(String.valueOf(success)); //default logger lever
        logger.warn("warn");
        logger.error("error");
    }

    @Test
    public void testDataSource() {
        System.out.println(dataSource.getClass());
    }

    @Test
    public void testDog() {
        System.out.println(dog);
    }

    @Test
    public void testMybatis() {
        AppCache appCache = appCacheDao.get("15458977282070040010100400000061");
        System.out.println("结果:"+appCache);
    }
}
