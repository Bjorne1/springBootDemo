package com.example.config;

import com.example.person.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 将PersonService注入容器中
 * @Author: WenChangSheng
 * @Date: Created in 2018/12/26 15:01
 */
@Configuration
public class MyConfig {

    @Bean
    public PersonService personService() {
        System.out.println("I am been created!");
        return new PersonService();
    }
}
