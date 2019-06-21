package com.example.springbootjpa.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:12 2019/6/18
 */
@Data
@Entity
@ToString
public class TeachDto {
    @Id
    private String id;
    @Column(name="tea_name")
    private  String name;
    @Column(name = "tea_subject")
    private String subject;
}