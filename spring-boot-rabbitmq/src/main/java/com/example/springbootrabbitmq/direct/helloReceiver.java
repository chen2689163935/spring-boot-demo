package com.example.springbootrabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:  消息接收
 *
 * @author yanpenglei
 * @create 2017-10-25 0:47
 **/
@Component
@RabbitListener(queues = "hello")
public class helloReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("我接收到了发送到hello的消息" + message);
    }
}
