package com.huang.curriculum.service;

import com.huang.curriculum.pojo.vo.CourseSchedule;

import java.util.List;

/***
 * 课程表获取接口
 *
 * @author Created by Createsequence on 2020-02-24 11:52
 */
public interface DailyScheduleService {

    /***
     * 课表查询
     *
     * @param jsessionId 从header获取的JSESSIONID
     * @return java.util.List<java.util.List<com.huang.curriculum.pojo.vo.CourseSchedule>>
     * @author Created by Createsequence on 2020-02-24 16:43
     */
    List<List<CourseSchedule>> getDailySchedule(String jsessionId);

}
