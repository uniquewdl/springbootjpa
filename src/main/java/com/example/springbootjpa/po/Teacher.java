package com.example.springbootjpa.po;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 9:43 2019/6/18
 */
@Data
@ToString
@Entity
@Table(name="teacher_new")
public class Teacher {
    @Id
    private String id;
    @Column(name = "name",length = 50)
    private String tea_name;
    private String tea_subject;
    private String tea_school;
    private String tea_class;
}