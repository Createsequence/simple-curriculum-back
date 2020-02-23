package com.huang.curriculum.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author：黄成兴
 * @Date：2019-12-11 16:09
 * @Description：课程成绩实体类
 */
@ApiModel("课程成绩实体类")
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class CourseScore {

    @ApiModelProperty("开课学期")
    private String startDate;

    @ApiModelProperty("课程编号")
    private String courseNumber;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("考试成绩")
    private Double grade;

    @ApiModelProperty("学分")
    private Double credit;

    @ApiModelProperty("课时")
    private String totalTime;

    @ApiModelProperty("绩点")
    private Double gardePoint;

    @ApiModelProperty("课程属性")
    private String properties;


}
