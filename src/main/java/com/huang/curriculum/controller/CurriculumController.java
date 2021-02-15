package com.huang.curriculum.controller;

import com.huang.curriculum.common.result.Result;
import com.huang.curriculum.pojo.vo.CourseSchedule;
import com.huang.curriculum.pojo.vo.CourseScore;
import com.huang.curriculum.pojo.vo.ExamSchedule;
import com.huang.curriculum.service.DailyScheduleService;
import com.huang.curriculum.service.ExamService;
import com.huang.curriculum.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/***
 * app接口
 *
 * @author Created by Createsequence on 2020-02-24 16:38
 */
@Slf4j
@Api("数据获取接口，需要先登录以获取cookie")
@RequestMapping("/api/")
@RestController
public class CurriculumController {

    @Autowired
    DailyScheduleService scheduleService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    ExamService examService;

    @Autowired
    HttpServletRequest request;

    /***
     * 获取课程表
     *
     * @return com.huang.curriculum.common.result.Result
     * @author Created by Createsequence on 2020-02-24 16:38
     */
    @ApiOperation("获取课程表")
    @GetMapping("listCourseSchedule")
    public Result listCourseSchedule() {
        //获取数据集
        List<List<CourseSchedule>> lists = scheduleService.getDailySchedule(getCookie());
        return Result.success(lists);
    }
    
    /***
     * 获取成绩
     *
     * @return com.huang.curriculum.common.result.Result
     * @author Created by Createsequence on 2020-02-24 16:38
     */
    @ApiOperation("获取成绩")
    @GetMapping("listCourseScore")
    public Result listCourseScore(){
        //获取数据集
        List<CourseScore> list = scoreService.getScore(getCookie());
        return Result.success(list);
    }
    
    /***
     * 获取考试安排
     *
     * @return com.huang.curriculum.common.result.Result
     * @author Created by Createsequence on 2020-02-24 16:38
     */
    @ApiOperation("获取考试安排")
    @GetMapping("listExamSchedule")
    public Result listExamSchedule(){
        //获取数据集
        List<ExamSchedule> list = examService.getExamSchedule(getCookie());
        return Result.success(list);
    }

    /**
     * 获取cookie
     */
    private String getCookie(){
        String cookie = request.getHeader("JSESSIONID");
        log.info(cookie);

        return cookie;
    }
}
