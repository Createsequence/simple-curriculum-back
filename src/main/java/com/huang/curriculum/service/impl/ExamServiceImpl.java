package com.huang.curriculum.service.impl;

import com.huang.curriculum.common.constans.Constans;
import com.huang.curriculum.common.constans.UrlEnum;
import com.huang.curriculum.common.util.CheckUtils;
import com.huang.curriculum.pojo.vo.ExamSchedule;
import com.huang.curriculum.service.ExamService;
import com.huang.curriculum.common.util.JsoupUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.*;

/***
 * 考试安排获取接口实现类
 *
 * @author Created by Createsequence on 2020-02-24 13:40
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Override
    public List<ExamSchedule> getExamSchedule(String jsessionId) {
        //添加cookie
        Map<String, String> cookie = new HashMap<>(2);
        cookie.put("JSESSIONID", CheckUtils.checkJessionId(jsessionId));

        //获取当前学期
        Document document = JsoupUtils.getJsoupDocument(UrlEnum.NOW_DATE_URL.getUrl(), null, cookie);
        //检验是否报错
        CheckUtils.checkResponse(document);

        //无错则解析获取当前学期
        String dateStr = document
                .select("select#xnxqid option[selected]").first()
                .text();

        //装填数据
        Map<String, String> params = new HashMap<>(2);
        params.put("xnxqid", dateStr);
        //获取考试安排
        Elements dateTable = JsoupUtils.getJsoupDocument(UrlEnum.EXAM_SCHEDULE_URL.getUrl(), params, cookie)
                .select("#dataList tbody tr");

        //提取tr标签内子集合
        List<Elements> elementsList = JsoupUtils.getElementsChildrens(dateTable ,true);

        //遍历集合,封装考试安排实体类集合
        List<ExamSchedule> examSchedules = new ArrayList<>(dateTable.size());
        //如果没有数据直接返回空集合
        if (elementsList.size() < Constans.EMPTY_EXAM_NUM){
            return examSchedules;
        }
        for (Elements elements : elementsList) {

            //组装考试安排实体类
            ExamSchedule examSchedule = new ExamSchedule()
                    .setCourseName(elements.get(3).text())
                    .setExamDate(elements.get(4).text())
                    .setExamClassroom(elements.get(5).text())
                    .setDate(elements.get(4).text().split(" ")[0]);

            //装入集合
            examSchedules.add(examSchedule);

        }

        return examSchedules;
    }

}
