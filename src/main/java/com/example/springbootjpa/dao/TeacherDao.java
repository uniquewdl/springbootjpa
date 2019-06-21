package com.example.springbootjpa.dao;

import com.example.springbootjpa.po.Teacher;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:17 2019/6/18
 */
public interface TeacherDao extends BaseRepository<Teacher, String> {
    List<Teacher> findAll();
    @Query(value = " update teacher  set teacher_name =?1 where  teacher_id =?2 ", nativeQuery = true)
    void updateTeacher(String name,Integer id);
    @Query(value=" select * from teacher ",nativeQuery = true)
    List<Teacher> findAllQuery();
    @Query(value = "select  t.teacher_id teacherid , t.teacher_name teacherName, s.id studentId   from teacher t,  student s where t.teacher_id=s.id ",nativeQuery = true)
    List<Object []> joinQuery();
}