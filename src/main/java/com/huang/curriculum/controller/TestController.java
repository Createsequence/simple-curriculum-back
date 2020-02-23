package com.huang.curriculum.controller;

import com.huang.curriculum.common.result.Result;
import com.huang.curriculum.pojo.vo.CourseSchedule;
import com.huang.curriculum.pojo.vo.CourseScore;
import com.huang.curriculum.pojo.vo.ExamSchedule;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：黄成兴
 * @Date：2020-02-23 11:47
 * @Description：测试接口
 */
@Api(value = "Api-test", description = "测试接口")
@RequestMapping("/test/")
@RestController
public class TestController {

    @ApiOperation(value = "获取响应类",response = Result.class)
    @RequestMapping(method = RequestMethod.GET, path =  "call")
    public Result call(){
        return Result.success("吱一声以表示项目运行");
    }

    @ApiOperation(value = "获取课程表",response = CourseSchedule.class)
    @RequestMapping(method = RequestMethod.GET, path =  "getCourseSchedule")
    public CourseSchedule getCourseSchedule(){
        return new CourseSchedule();
    }

    @ApiOperation(value = "获取考试安排实体类",response = ExamSchedule.class)
    @RequestMapping(method = RequestMethod.GET, path =  "getExamSchedule")
    public ExamSchedule getExamSchedule(){
        return new ExamSchedule();
    }

    @ApiOperation(value = "获取课程成绩实体类",response = CourseScore.class)
    @RequestMapping(method = RequestMethod.GET, path =  "getCourseScore")
    public CourseScore getCourseScore(){
        return new CourseScore();
    }

}
