package com.example.springbootjpa.controller;

import com.example.springbootjpa.po.Teacher;
import com.example.springbootjpa.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 9:41 2019/6/18
 */
@RestController
@Slf4j
@RequestMapping("jap_controller")
public class JpaController {

    @Autowired
    private TeacherService teacherService;
    @RequestMapping("find_all")
    public List<Teacher> findAll(){
        List<Teacher> result= teacherService.findAll();
        return result;
    }
    @RequestMapping("/queryTeacherByName")
    public List<Teacher> queryTeacherByName(String teachName){
        List<Teacher> result=  teacherService.findTeacherByName(teachName);
        return result;
    }
    @RequestMapping("/updateTeacher")
    public void updateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
    }

    @RequestMapping("/findAllQuery")
    public List<Teacher> findAllQuery(){
    return     teacherService.findAllQuery();
    }

    @RequestMapping("joinQuery")
    public List<Object []> joinQuery(){
      return   teacherService.joinQuery();
    }





}