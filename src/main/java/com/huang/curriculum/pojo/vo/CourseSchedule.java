package com.huang.curriculum.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author：黄成兴
 * @Date：2019-12-10 21:04
 * @Description：课程表实体类
 */
@ApiModel("课程表实体类")
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class CourseSchedule{

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("教室")
    private String courseClassroom;

    @ApiModelProperty("上课时间")
    private String courseDate;

    @ApiModelProperty("任课老师")
    private String courseTeacher;

    @ApiModelProperty("是否空课")
    private Boolean isEmptyCourse;

    @ApiModelProperty("如果重课，则课程放于此集合")
    private List<CourseSchedule> children;

    public CourseSchedule() {
        this.isEmptyCourse = false;
    }
}
