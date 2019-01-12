package com.example.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: wenchangsheng
 * @date: created in 2019/1/12
 */
@Configuration
public class RabbitConfig {

    /**
     * 修改默认序列化
     */
    @Bean
    public MessageConverter converterMessage() {
        return new Jackson2JsonMessageConverter();
    }
}
