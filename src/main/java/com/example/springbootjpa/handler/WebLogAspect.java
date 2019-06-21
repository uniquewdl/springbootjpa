package com.example.springbootjpa.handler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 14:16 2019/5/15
 */
@Slf4j
//@Component
@Aspect
public class WebLogAspect {
    @Pointcut("execution(public * com.example.springbootjpa.controller..*.*(..))")
    public void webLog() {

    }
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("=============>url:" + request.getRequestURL());
        log.info("=============>ip:" + request.getRemoteAddr());
        log.info("=============>http_method" + request.getMethod());
      //  String arg = (java.lang.String) joinPoint.getArgs()[0];
       log.info("=====================>第一个入参为：" + joinPoint.getArgs()[0]);
    }
    @AfterReturning(returning = "retttt",pointcut = "webLog()")
    public void doAfterReturning(Object retttt) {
        log.info("---------------------->后置通知:" + retttt);
    }
}