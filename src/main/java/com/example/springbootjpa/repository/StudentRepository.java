package com.example.springbootjpa.repository;

import com.example.springbootjpa.po.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 9:57 2019/5/16
 */
public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
    @Override
    List<Student> findAll(Specification<Student> specification);
}
