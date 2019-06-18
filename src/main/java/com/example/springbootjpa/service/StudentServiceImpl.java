package com.example.springbootjpa.service;

import com.example.springbootjpa.po.Student;
import com.example.springbootjpa.repository.StudentRepository;
import com.example.springbootjpa.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 11:39 2019/5/16
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> findAllByContition(StudentVo vo) {
        Integer id = vo.getId();
        String name = vo.getName();
        Pageable pageable= PageRequest.of(0, 10);
        return  studentRepository.findAll(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (!"".equals(name) && null != name) {
                    list.add(cb.equal(root.get("name").as(String.class), name));
                }
                if (!"".equals(id) && null != id) {
                    list.add(cb.equal(root.get("id").as(Integer.class), id));
                }
                cq.where(cb.and(list.toArray(new Predicate[list.size()])));
                return cq.getRestriction();
            }
        },pageable);
    }
}