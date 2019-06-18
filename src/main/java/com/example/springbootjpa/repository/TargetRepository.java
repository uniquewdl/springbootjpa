package com.example.springbootjpa.repository;


import com.example.springbootjpa.po.Exploration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 11:14 2019/5/13
 */
@Repository
public interface TargetRepository extends JpaRepository<Exploration,Integer> {
    Exploration findById(String id);
}
