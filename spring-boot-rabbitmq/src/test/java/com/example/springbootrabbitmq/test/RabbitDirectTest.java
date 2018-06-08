package com.example.springbootrabbitmq.test;

import com.example.springbootrabbitmq.run.Startup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述: 默认的交换机模式
 *
 * @author: yanpenglei
 * @create: 2017/10/25 1:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
public class RabbitDirectTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 任何发送到Direct Exchange的消息都会被转发到RouteKey中指定的Queue。
     1.一般情况可以使用rabbitMQ自带的Exchange：""(该Exchange的名字为空字符串，下文称其为default Exchange)。
     2.这种模式下不需要将Exchange进行任何绑定(binding)操作
     3.消息传递时需要一个RouteKey，可以简单的理解为要发送到的队列名字。
     4.如果vhost中不存在RouteKey中指定的队列名，则该消息会被抛弃。
     */

    @Test
    public void sendHelloTest() {
        String context = "此消息在，默认的交换机模式队列下，有 helloReceiver 可以收到";
        String routeKey = "hello";
        context = "routeKey:" + routeKey + ",context:" + context;
        System.out.println("陈龙 : " + context);
        this.rabbitTemplate.convertAndSend(routeKey, context);
    }

    /*@Test
    public void sendDirectTest() {
        String context = "此消息在，默认的交换机模式队列下，有 DirectReceiver 可以收到";
        String routeKey = "direct";
        String exchange = "directExchange";
        context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;
        System.out.println("陈龙A : " + context);
        // 推荐使用 sendHello（） 方法写法，这种方式在 Direct Exchange 多此一举，没必要这样写
        this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
    }*/


}
