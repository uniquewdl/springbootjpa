package com.example.springbootjpa.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 9:43 2019/6/18
 */
@Data
@ToString
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    private Integer teacher_id;
    private String teacher_name;
    private String sex;
    private Integer age;
    private Date birthday;
    private Integer is_value;
    private Integer deleted;
    private String name;
}