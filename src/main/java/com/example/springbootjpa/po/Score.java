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
@Data
@ToString
@Entity
@Table(name = "score")
public class Score {
    @Id
    private String studid;
    @Column
    private String stuname;
    @Column
    private Integer score;
    @Column
    private Date birthday;
    @Column(name = "teacher_id",updatable = false, insertable = false)
    private Integer teacher_id;
    @OneToOne()
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    // @JsonIgnoreProperties(value = {"teacher"}, allowSetters = true)
    private Teacher teacher;


}