package com.example.springbootjpa.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:20 2019/5/16
 */
@Data
@ToString
public class ScoreVo {
    private Integer id;
    private String stuname;
    private Integer score;
}