package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author wcs
 * EnableCaching： 打开缓冲开关
 * EnableRabbit: 打开基于注解的rabbit
 */
@SpringBootApplication
@MapperScan(value = "com.example.*.dao")
@EnableCaching
@EnableRabbit
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
