package com.example.springbootjpa.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 13:25 2019/6/21
 */
@Component
public class HelloSend2 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg){
        String sendMsg=msg+new Date();
        System.out.println("send1:"+sendMsg);
        this.amqpTemplate.convertAndSend("helloQueue",sendMsg);
    }


}