package com.huang.curriculum.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/***
 * 考试安排实体类
 *
 * @author Created by Createsequence on 2019-12-11 12:38
 */
@ApiModel("考试安排实体类")
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class ExamSchedule{

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("考场")
    private String examClassroom;

    @ApiModelProperty("考试时间")
    private String examDate;

    @ApiModelProperty("当前时间")
    private String date;
}
