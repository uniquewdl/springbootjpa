package com.example.springbootjpa.controller;

import com.example.springbootjpa.po.Exploration;
import com.example.springbootjpa.po.PageResponse;
import com.example.springbootjpa.po.Score;
import com.example.springbootjpa.po.Student;
import com.example.springbootjpa.service.StudentService;
import com.example.springbootjpa.service.TargetService;
import com.example.springbootjpa.vo.StudentVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 11:07 2019/5/13
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TargetService targetService;

    @Autowired
    private StudentService studentService;

    /*  @GetMapping ("/add")
      @ApiModelProperty(value="id" ,required=true)
      @ApiOperation(value = "新增信息")
      public String addTarget() {
          String returnValue = "";
          try {
              Target target =null;
              targetService.save(target);
              returnValue = "success";
          } catch (Exception e) {
              returnValue = e.getMessage();
          }
          return returnValue;
      }
      @ApiOperation(value = "查找信息")
      @GetMapping("/find/{name}")
      public Target  findOneById(@PathVariable ("name") String userName){
          return  targetService.findTargetByName(userName);
      }
      @ApiOperation(value = "保存信息")
      @GetMapping("/save")
      public String saveTarget(@CurrentUser  Target target){
          System.out.println("======"+target);
        //  targetService.save(target);
          return "success";
      }
      @ApiOperation(value = "首页信息")
      @PostMapping("/index")
      public String index() {
          return "success";
      }*/
/*  @Autowired
  private TargetRepository targetRepository;

    @RequestMapping("/findProperty/{id}")
    @ApiOperation(value="查询房源信息")
    @ResponseBody
    public Property getPropertyById(@PathVariable("id") String id){
        Property property=new Property();
        System.out.println("-=-=-=-=-=-=-="+id);
        property= targetRepository.findById(id);
        return property;
    }*/
    @ApiOperation(value = "查找信息")
    @GetMapping("/find/{name}")
    public Exploration findOneById(@PathVariable("name") String userName) {
        return targetService.findTargetByName(userName);
    }

    @ApiOperation(value = "查找分数信息")
    @GetMapping("/findScore/{stuid}")
    public Score findScore(@PathVariable("stuid") Integer stuid) {
        Score scroe = new Score();
        scroe = targetService.findScoreById(stuid);
        return scroe;
    }

    @ApiOperation(value = "模糊查找分数")
    @GetMapping("/findByNameLike")
    @ResponseBody
    public List<Score> findByNameLike(String stuName) {
        return targetService.findByStuNameLike(stuName);
    }

    @ApiOperation(value = "查询分数小于某个值的所有结果")
    @GetMapping("/lessThan/{score}")
    public List<Score> findLessThanByScore(@PathVariable("score") Integer score) {
        List<Score> byScoreLessThan = targetService.findByScoreLessThan(score);
        return byScoreLessThan;
    }

    @ApiOperation(value = "根据条件查询学生表信息")
    @GetMapping("/findStudent")
    public PageResponse findStudnet(StudentVo vo) {
        Page<Student> pageResult = studentService.findAllByContition(vo);
        PageResponse response=new PageResponse();
     return    response.result("data",pageResult).success();
    }
}
