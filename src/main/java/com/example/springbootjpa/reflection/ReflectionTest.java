package com.example.springbootjpa.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 8:41 2019/5/27
 */
public class ReflectionTest {
    public static void main(String args[]) throws ClassNotFoundException {
        Class studentClass= Class.forName("com.example.springbootjpa.po.Student");
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        System.out.println("所有方法为：");
        for(Method method:declaredMethods){
            System.out.println(method);
        }
        Field[] declaredFields = studentClass.getDeclaredFields();
        System.out.println("所有属性：");
        for(Field declare :declaredFields){
            System.out.println(declare);
        }
    }

}