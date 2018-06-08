package com.example.springbootwebsockets.response;

/**
 * @Description:
 * @Author: chenlong
 * @Date: create in 14:15 2018/6/8
 * @Modified: By
 */
public class ResponseMessage {

    private String responseMessage;

    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage(){
        return responseMessage;
    }


}
