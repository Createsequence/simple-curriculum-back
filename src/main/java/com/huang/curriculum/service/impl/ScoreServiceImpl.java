package com.huang.curriculum.service.impl;

import com.huang.curriculum.common.constans.UrlEnum;
import com.huang.curriculum.common.util.CheckUtils;
import com.huang.curriculum.pojo.vo.CourseScore;
import com.huang.curriculum.service.ScoreService;
import com.huang.curriculum.common.util.JsoupUtils;
import com.huang.curriculum.common.util.TypeConverterUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 考试成绩获取接口实现类
 *
 * @author Created by Createsequence on 2020-02-24 13:18
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Override
    public List<CourseScore> getScore(String jsessionId) {
        //添加cookie
        Map<String, String> cookie = new HashMap<>(2);
        cookie.put("JSESSIONID", CheckUtils.checkJessionId(jsessionId));

        //添加参数
        Map<String, String> params = new HashMap<>(2);
        params.put("xsfs", "all");
        //获取页面数据
        Document document = JsoupUtils.getJsoupDocument(UrlEnum.SCORE_URL.getUrl(), params, cookie);
        //检验是否报错
        CheckUtils.checkResponse(document);

        //获取成绩数据
        Elements dataTable = document.select("#dataList tbody tr");

        //提取tr标签内子集合
        List<Elements> elementsList = JsoupUtils.getElementsChildrens(dataTable ,true);

        //遍历集合,封装考试成绩实体类集合
        List<CourseScore> courseScores = new ArrayList<>(elementsList.size());
        for (Elements elements : elementsList) {

            //组装考试成绩实体类
            CourseScore courseScore = new CourseScore()
                    .setStartDate(elements.get(1).text())
                    .setCourseNumber(elements.get(2).text())
                    .setCourseName(elements.get(3).text())
                    .setGrade(TypeConverterUtils.toDouble(elements.get(4).text()))
                    .setCredit(TypeConverterUtils.toDouble(elements.get(5).text()))
                    .setTotalTime(elements.get(6).text())
                    .setGardePoint(TypeConverterUtils.toDouble(elements.get(7).text()))
                    .setProperties(elements.get(9).text());
            //装入集合
            courseScores.add(courseScore);

        }

        return courseScores;
    }

}
