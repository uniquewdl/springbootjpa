package com.example.springbootjpa.timing;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 9:29 2019/5/21
 */
public class TestTime {
    public static void main(String args[]){
        long time = 1557994203319l;
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new Date(time);
        String str = sdf.format(date);
        System.out.println(str);
    }

}