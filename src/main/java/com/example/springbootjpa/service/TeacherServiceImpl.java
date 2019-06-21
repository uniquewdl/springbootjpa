package com.example.springbootjpa.service;
import com.example.springbootjpa.dao.TeacherDao;
import com.example.springbootjpa.po.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:16 2019/6/18
 */
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public List<Teacher> findTeacherByName(String teachName) {
        Pageable pageable = PageRequest.of(0, 10);
       return teacherDao.findAll(new Specification<Teacher>() {
            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (!StringUtils.isEmpty(teachName)) {
                    list.add(cb.like(root.get("teacher_name").as(String.class), "%" + teachName + "%"));
                }
                list.add(cb.lt(root.get("age").as(Integer.class),24));
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        });
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        String name =teacher.getName();
        Integer id =teacher.getTeacher_id();
        teacherDao.updateTeacher(name,id);
    }

    @Override
    public List<Teacher> findAllQuery() {
        return teacherDao.findAllQuery();
    }

    @Override
    public List<Object []> joinQuery() {
        return teacherDao.joinQuery();
    }


}