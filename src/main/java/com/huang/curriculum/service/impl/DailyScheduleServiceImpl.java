package com.huang.curriculum.service.impl;

import com.huang.curriculum.common.constans.Constans;
import com.huang.curriculum.common.constans.UrlEnum;
import com.huang.curriculum.common.util.CheckUtils;
import com.huang.curriculum.pojo.vo.CourseSchedule;
import com.huang.curriculum.service.DailyScheduleService;
import com.huang.curriculum.common.util.JsoupUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * 课程表获取接口实现类
 *
 * @author Created by Createsequence on 2020-02-24 11:52
 */
@Slf4j
@Service
public class DailyScheduleServiceImpl implements DailyScheduleService {

    @Override
    public List<List<CourseSchedule>> getDailySchedule(String jsessionId) {
        //添加cookie
        Map<String, String> cookie = new HashMap<>(2);
        cookie.put("JSESSIONID", CheckUtils.checkJessionId(jsessionId));

        //获取页面数据
        Document document = JsoupUtils.getJsoupDocument(UrlEnum.DAILY_SCHEDULE_URL.getUrl(), null, cookie);
        //检验是否报错
        CheckUtils.checkResponse(document);

        //获取课表数据
        Elements dataTable = document
                //只获取已排课课表
                .select("#kbtable").first()
                .select("tbody tr");

        //提取每天的课表集合
        List<Elements> elementsList = JsoupUtils.getElementsChildrens(dataTable ,true);

        //提取每一课时的课程
        elementsList = elementsList.stream()
                .map(elements -> elements.select("td .kbcontent"))
                .collect(Collectors.toList());
        //去掉最后的备注行
        elementsList.remove(elementsList.size() -1 );

        //遍历集合,封装每一课时的课程安排实体类集合
        List<List<CourseSchedule>> lists = new ArrayList<>(6);
        for (Elements elements : elementsList){

            //遍历集合，组装每一天的课程安排实体类
            List<CourseSchedule> courseSchedules = new ArrayList<>(7);
            for (Element elem : elements){
                CourseSchedule courseSchedule = new CourseSchedule();

                //获取课程名称
                String name = elem.text().split(" ")[0];

                //判断是否空课
                if (name.length() == 0){
                    courseSchedule.setIsEmptyCourse(true);
                }else {
                    //判断是否重课
                    if (elem.text().contains("---------------------")){
                        //如果重课，处理重课的情况
                        courseSchedule = getMultipleCourseSchedule(elem);
                    }else {
                        //不是空课也不重课
                        courseSchedule = getCourse(elem.text());
                    }
                }
                //添加至某一课时的课程集合
                courseSchedules.add(courseSchedule);
            }

            //添加至一周所有课程集合
            lists.add(courseSchedules);
        }

        return lists;
    }

    /***
     * 将时间重合的课程整合成一个课程对象
     *
     * @param element 网页元素
     * @return com.huang.curriculum.pojo.vo.CourseSchedule
     * @author Created by Createsequence on 2020-02-24 17:01
     */
    private CourseSchedule getMultipleCourseSchedule(Element element){
        //通过分割线，将时间重合的课程分开
        String[] els = element.text().split("---------------------");

        //遍历组装课程对象
        List<CourseSchedule> courseSchedules = new ArrayList<>(els.length);
        for (String string : els){

            //组装课程对象
            CourseSchedule courseSchedule = getCourse(string);
            //装入集合
            courseSchedules.add(courseSchedule);

        }

        //返回一个含有子集合的课程安排对象
        return new CourseSchedule()
                .setChildren(courseSchedules);
    }

    /***
     * 将时间重合的课程整合成一个课程对象
     *
     * @param courseStr 课表字符串
     * @return com.huang.curriculum.pojo.vo.CourseSchedule
     * @author Created by Createsequence on 2020-02-24 17:01
     */
    private CourseSchedule getCourse(String courseStr){
        //组装课程对象
        String[] courseArr = courseStr.split(" ");

        CourseSchedule courseSchedule = new CourseSchedule()
                .setCourseName(courseArr[0])
                .setCourseTeacher(courseArr[1])
                .setCourseDate(courseArr[2]);

        //判断是否有教室
        if (courseArr.length > Constans.EMPTY_COURSE_NUM){
            //有教室就插入
            courseSchedule.setCourseClassroom(courseArr[3]);
        }else {
            //没有就给默认值
            courseSchedule.setCourseClassroom("暂无教室");
        }

        return courseSchedule;
    }

}
