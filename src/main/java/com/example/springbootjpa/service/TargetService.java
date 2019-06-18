package com.example.springbootjpa.service;

import com.example.springbootjpa.po.Exploration;
import com.example.springbootjpa.po.Score;
import com.example.springbootjpa.vo.ScoreVo;

import java.util.List;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 11:12 2019/5/13
 */
public interface TargetService {
  /*  public void save(Target target);
    public void delete(Integer id);
    public List<Target> findAll();
    public  Target findTargetByName(String name);*/

    Exploration findTargetByName(String userName);

    Score findScoreById(Integer stuid);

    List<Score> findByStuNameLike(String stuName);

    /**
     * 查询分数小于某个值的
     */
    List<Score> findByScoreLessThan(Integer score);

    /**
     * 复杂查询
     */
    List<Score> findAllByContion(ScoreVo vo);
}
