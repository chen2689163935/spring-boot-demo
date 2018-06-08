package com.example.springbootwebsockets.controller;

import com.example.springbootwebsockets.request.RequestMessage;
import com.example.springbootwebsockets.response.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Description:
 * @Author: chenlong
 * @Date: create in 14:16 2018/6/8
 * @Modified: By
 *
 *  @SendTo 注解表示当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息
 */

@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage requestMessage){
        System.out.println(requestMessage.getName());
        return new ResponseMessage("welcome," +requestMessage.getName()+" !");
    }


}
