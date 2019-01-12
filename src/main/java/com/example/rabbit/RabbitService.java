package com.example.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description: 用于监听消息队列, 还要打开@enableRabbit
 * @author: wenchangsheng
 * @date: created in 2019/1/12
 */
@Service
public class RabbitService {

    @RabbitListener(queues = "test.direct")
    public void getMessage(Map<String, String> map) {
        System.out.println("收到消息:" + map);
    }
}
