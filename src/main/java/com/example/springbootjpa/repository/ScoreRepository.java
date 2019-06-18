package com.example.springbootjpa.repository;
import com.example.springbootjpa.po.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 16:32 2019/5/15
 */
public interface ScoreRepository   extends JpaRepository<Score,Integer> {
    Score    findByStuId(Integer stuid);
    List<Score> getByStuNameLike(String stuName);
    List<Score> findByScoreLessThan(Integer score);
}