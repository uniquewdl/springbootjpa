package com.example.springbootjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:21 2019/6/18
 */
@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaRepository<T,ID> , JpaSpecificationExecutor<T>{

}
