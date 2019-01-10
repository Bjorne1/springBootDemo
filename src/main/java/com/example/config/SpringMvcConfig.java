package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wenchangsheng
 * @Description: 原有mvc.xml的配置都可以在这里面自定义配置
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/filter").setViewName("success");
    }
}
