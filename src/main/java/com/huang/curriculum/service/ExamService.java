package com.huang.curriculum.service;

import com.huang.curriculum.pojo.vo.ExamSchedule;

import java.util.List;

/***
 * 考试安排获取接口
 *
 * @author Created by Createsequence on 2020-02-24 13:39
 */
public interface ExamService {

    /***
     * 获取考试安排查询
     *
     * @param jsessionId 从header获取的JSESSIONID
     * @return java.util.List<com.huang.curriculum.pojo.vo.ExamSchedule>
     * @author Created by Createsequence on 2020-02-24 16:43
     */
    List<ExamSchedule> getExamSchedule(String jsessionId);

}
