package com.example.springbootjpa.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 11:01 2019/6/21
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceive2 {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver2:"+hello);
    }

}