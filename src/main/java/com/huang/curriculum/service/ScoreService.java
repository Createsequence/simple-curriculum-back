package com.huang.curriculum.service;

import com.huang.curriculum.pojo.vo.CourseScore;

import java.util.List;

/***
 * 考试成绩获取接口
 *
 * @author Created by Createsequence on 2020-02-24 16:43
 */
public interface ScoreService {

    /***
     * 成绩查询
     *
     * @param jsessionId 从header获取的JSESSIONID
     * @return java.util.List<com.huang.curriculum.pojo.vo.ExamSchedule>
     * @author Created by Createsequence on 2020-02-24 16:43
     */
    List<CourseScore> getScore(String jsessionId);

}
