package com.example.person.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2018/12/26 14:47
 */
@RestController
public class PersonController {

    @Value("${person.name}")
    private String name;

    /**
     * value的应用场景:仅某个地方要使用到配置文件中的某个值时
     * 否则使用@ConfigurationProperties
     */
    @RequestMapping("hello")
    public String getValueFromApplication() {
        return name;
    }
}
