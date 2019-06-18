package com.example.springbootjpa.handler;

import com.example.springbootjpa.annoation.CurrentUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 13:06 2019/5/14
 */
@Aspect
@Component
public class TestAspect {
    @Before("@annotation(currentUser)")
    public  void doBefore(JoinPoint joinPoint, CurrentUser currentUser){
    Object[] args = joinPoint.getArgs();
    System.out.println(args);
    System.out.println("--------------------》》进入通知" );
}
}