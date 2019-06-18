package com.example.springbootjpa.po;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:38 2019/5/14
 */
@Data
@ToString
public class User {
    private String userName;
    private String password;
}