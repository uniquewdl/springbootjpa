package com.example.springbootjpa.service;

import com.example.springbootjpa.po.Student;
import com.example.springbootjpa.vo.StudentVo;
import org.springframework.data.domain.Page;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 11:38 2019/5/16
 */
public interface StudentService {
    Page<Student> findAllByContition(StudentVo vo);
}