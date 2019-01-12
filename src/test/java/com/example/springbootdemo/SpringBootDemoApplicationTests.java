package com.example.springbootdemo;

import com.example.cache.bean.AppCache;
import com.example.cache.dao.AppCacheDao;
import com.example.person.bean.Dog;
import com.example.person.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("结果:" + appCache);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 用于绑定exchange,queues
     */
    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 发送消息
     */
    @Test
    public void send() {
        Map<String, String> map = new HashMap<>();
        map.put("HELLO", "你好");
        map.put("Listener", "监听");
        //广播类型
        //对象被默认序列化以后发出去，所以说乱的，改用json序列化见rabbitConfig
        rabbitTemplate.convertAndSend("test.direct", "test.direct", map);
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("test.direct");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    public void createExchange() {
        amqpAdmin.declareExchange(new DirectExchange("createExchangeByJava"));
        //amqpAdmin.declareQueue(new Queue("createByJava"));
    }

}
