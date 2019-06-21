package com.example.springbootjpa.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 15:32 2019/6/19
 */
@ToString
@Data
public class TeacherStudentDto {

    private Integer teacherid;
    private String teacherName;
    private String  sex;
    private Integer age;

    private  String studentName;
    private  Integer studentId;


}