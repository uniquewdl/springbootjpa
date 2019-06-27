package com.example.springbootjpa.po;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: Dian Lun Wei
 * @Description:
 * @Date: Created in 14:30 2019/6/27
 */
@Entity
@ToString
@Table(name = "person")
public class Person {
    @Id
    private Integer id;
    @Column(name = "first")
    private String first;
    @Column(name = "last")
    private String last;
    @Column(name = "dateofbirth")
    private Date dateofbirth;
    @Column(name = "placeofbirth")
    private String placeofbirth;
}