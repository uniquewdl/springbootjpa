package com.example.springbootjpa.service;

import com.example.springbootjpa.po.Exploration;
import com.example.springbootjpa.po.Score;
import com.example.springbootjpa.repository.ScoreRepository;
import com.example.springbootjpa.repository.TargetRepository;
import com.example.springbootjpa.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 11:13 2019/5/13
 */
@Service
public class TargetServiceImpl implements TargetService {
   @Autowired
    private TargetRepository targetRepository;
    @Autowired
    private ScoreRepository scoreRepository;
  /*   @Override
    public void save(@NotNull  Target target) {
        this.targetRepository.save(target);
    }
    @Override
    public void delete(Integer id) {
    this.targetRepository.deleteById(id);
    }
    @Override
    public List<Target> findAll() {
        return (List<Target>) targetRepository.findAll();
    }
    @Override
    public Target findTargetByName(String name) {
        return targetRepository.findByTnameLike(name);
}*/
    @Override
    public Exploration findTargetByName(String userName) {
        return targetRepository.findById(userName);
    }
    @Override
    public Score findScoreById(Integer stuid) {
        return scoreRepository.findByStuId(stuid);
    }

    @Override
    public List<Score> findByStuNameLike(String stuName) {
        stuName="%"+stuName+"%";
        return scoreRepository.getByStuNameLike(stuName);
    }

    @Override
    public List<Score> findByScoreLessThan(Integer score) {
        return scoreRepository.findByScoreLessThan(score);
    }

    @Override
    public List<Score> findAllByContion(ScoreVo vo) {


        return null;
    }
}