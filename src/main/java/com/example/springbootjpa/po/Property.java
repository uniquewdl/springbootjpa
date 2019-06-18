package com.example.springbootjpa.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:48 2019/5/15
 */
@Data
@ToString
public class Property implements Serializable {
    private String id;
    private String address;
    private String companyId;
}