package com.example.springbootjpa.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 9:57 2019/5/16
 */
@Entity
@Data
@ToString
@Table(name = "student",schema="test")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name")
    private String name;

}