package com.example.springbootjpa.annoation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:34 2019/5/14
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CurrentUser {
}
