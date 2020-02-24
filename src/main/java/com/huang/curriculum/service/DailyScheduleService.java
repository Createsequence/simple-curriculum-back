package com.huang.curriculum.service;

import com.huang.curriculum.pojo.vo.CourseSchedule;

import java.util.List;

/**
 * @Author：黄成兴
 * @Date：2020-02-24 11:52
 * @Description：课程表获取接口
 */
public interface DailyScheduleService {

    /**
     * 日常课表查询
     * @param jsessionId 从header获取的“JSESSIONID”
     * @return
     */
    List<List<CourseSchedule>> getDailySchedule(String jsessionId);

}
