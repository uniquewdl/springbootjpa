package com.example.springbootjpa.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 16:23 2019/5/15
 */
@Table(name = "score",schema="test")
@Entity
@Data
@ToString
public class Score {
    @Id
    @Column(name="studid")
    private Integer stuId;

    @Column(name = "stuname")
    private String stuName;

    @Column(name = "score")
    private Integer score;

    @Column(name = "birthday")
    private Date birthday;
}