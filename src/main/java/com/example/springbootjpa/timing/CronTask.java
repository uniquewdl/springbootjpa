package com.example.springbootjpa.timing;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Author: weidl
 * e
 * @Date: Created in 15:18 2019/5/16
 */
@Component
@Configuration
public class CronTask {
    @Scheduled(cron = "0/10 * * * * ? ")
    public void reportCurrentTime() {
        System.out.println("this is my first schedule project==========   current time is :" + dateFormat().format(new Date()));
    }
    public SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }
}