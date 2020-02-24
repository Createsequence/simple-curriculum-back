package com.huang.curriculum.service;

import com.huang.curriculum.pojo.vo.ExamSchedule;

import java.util.List;

/**
 * @Author：黄成兴
 * @Date：2020-02-24 13:39
 * @Description：考试安排获取接口
 */
public interface ExamService {

    /**
     * 获取考试安排查询
     * @param jsessionId 从header获取的“JSESSIONID” 登录用户
     * @return
     */
    List<ExamSchedule> getExamSchedule(String jsessionId);

}
