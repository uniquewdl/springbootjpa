package com.example.springbootjpa.configuration;

import com.example.springbootjpa.po.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: weidl
 * @Description: 发送内容为实体类
 * @Date: Created in 13:43 2019/6/21
 */
@Component
public class UserSender {
    @Autowired
    private AmqpTemplate rabbitTempate;
    public  void send(){
        User user=new User();
        user.setUserName("张三");
        user.setPassword("123456789");
        System.out.println("user send:"+user.getUserName()+"/"+user.getPassword());
        this.rabbitTempate.convertAndSend("user",user);
    }
}