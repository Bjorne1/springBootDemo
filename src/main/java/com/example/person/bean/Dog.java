package com.example.person.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description: @ConfigurationProperties 默认使用的是application.yml配置文件
 *                用@PropertySource可以自定义配置文件
 * @Author: WenChangSheng
 * @Date: Created in 2018/12/26 11:35
 */
@PropertySource(value = "classpath:dog.properties")
@ConfigurationProperties(prefix = "dog")
@Component
public class Dog {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
