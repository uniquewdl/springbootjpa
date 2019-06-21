package com.example.springbootjpa.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:59 2019/6/21
 */
@Component
public class HelloSend1 {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send(){
        String  sendMsg="hello1"+new Date();
        System.out.println("send1:"+sendMsg);
        this.amqpTemplate.convertAndSend("helloQueue",sendMsg);
    }
}