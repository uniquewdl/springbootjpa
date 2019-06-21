package com.example.springbootjpa.controller;

import com.example.springbootjpa.configuration.HelloSend1;
import com.example.springbootjpa.configuration.HelloSend2;
import com.example.springbootjpa.configuration.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 11:02 2019/6/21
 */
@RestController
@RequestMapping("rabbitmq")
public class RabbitMqController {
    @Autowired
    private HelloSend1 helloSend1;
    @Autowired
    private HelloSend2 helloSend2;
    @Autowired
    private UserSender userSender;

    @RequestMapping("/hello")
    public  void hello(){
        helloSend1.send();
    }
    @RequestMapping("/oneTwoMany")
    public void oneTwoMany(){
        for(int i=0;i<10;i++){
            helloSend2.send("hellomsg:"+i);
        }
    }
    @RequestMapping("/userSend")
     public void userSend(){
        userSender.send();
    }
}