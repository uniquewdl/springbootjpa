package com.example.springbootjpa.service;

import com.example.springbootjpa.po.Score;
import com.example.springbootjpa.po.Teacher;

import java.util.List;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:16 2019/6/18
 */
public interface TeacherService {
    List<Teacher> findAll();

    List<Teacher> findTeacherByName(String teachName);

    void updateTeacher(Teacher teacher);

    List<Teacher> findAllQuery();

    List<Object[]> joinQuery();

    List<Teacher> findByName(String teacherName, Integer age);

    List<Score> findAllScore(String name,String teacherName);
}
