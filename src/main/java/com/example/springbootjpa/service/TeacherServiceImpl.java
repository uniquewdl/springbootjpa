package com.example.springbootjpa.service;

import com.example.springbootjpa.dao.ScoreDao;
import com.example.springbootjpa.dao.TeacherDao;
import com.example.springbootjpa.po.Score;
import com.example.springbootjpa.po.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
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
    @Autowired
    private ScoreDao scoreDao;

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
                list.add(cb.lt(root.get("age").as(Integer.class), 24));
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        });
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        String name = teacher.getName();
        Integer id = teacher.getTeacher_id();
        teacherDao.updateTeacher(name, id);
    }

    @Override
    public List<Teacher> findAllQuery() {
        return teacherDao.findAllQuery();
    }

    @Override
    public List<Object[]> joinQuery() {
        return teacherDao.joinQuery();
    }

    @Override
    public List<Teacher> findByName(String teacherName, Integer age) {
        return teacherDao.findAll(new Specification<Teacher>() {
            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate result = criteriaBuilder.like(root.get("teacher_name"), "%" + teacherName + "%");
                result = criteriaBuilder.and(result, criteriaBuilder.equal(root.get("age"), age));
                return result;
            }
        });
    }

    public List<Score> findAllScore(String name, String teacherName) {
        //关联查询
        return scoreDao.findAll(new Specification<Score>() {
            @Override
            public Predicate toPredicate(Root<Score> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicatesAreas = new ArrayList<>();
                Predicate predicate=null;
                Join<Score, Teacher> join = root.join("teacher_id", JoinType.LEFT);
                predicatesAreas.add(criteriaBuilder.equal(root.get("stuname"), name));
                predicatesAreas.add(criteriaBuilder.equal(join.get("teacher_id"), teacherName));
                predicate=criteriaBuilder.and(predicatesAreas.toArray(new Predicate[predicatesAreas.size()]));
                return predicate;
            }
        });
    }
}