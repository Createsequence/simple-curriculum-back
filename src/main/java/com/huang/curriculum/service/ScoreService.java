package com.huang.curriculum.service;

import com.huang.curriculum.pojo.vo.CourseScore;

import java.util.List;

/**
 * @Author：黄成兴
 * @Date：2020-02-24 13:15
 * @Description：考试成绩获取接口
 */
public interface ScoreService {

    /**
     * 成绩查询
     * @param jsessionId 从header获取的“JSESSIONID”
     * @return
     */
    List<CourseScore> getScore(String jsessionId);

}
