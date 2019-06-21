package com.example.springbootjpa.configuration;

import com.example.springbootjpa.po.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 13:47 2019/6/21
 */
@Component
@RabbitListener(queues = "user")
public class UserReceive {
    @RabbitHandler
    public void process(User user){
        System.out.println("user Receive:"+user.getUserName()+"/"+user.getPassword());
    }
}