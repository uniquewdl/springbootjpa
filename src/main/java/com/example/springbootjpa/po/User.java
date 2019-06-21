package com.example.springbootjpa.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:38 2019/5/14
 */
@Data
@ToString
public class User implements Serializable {
    private String userName;
    private String password;
}