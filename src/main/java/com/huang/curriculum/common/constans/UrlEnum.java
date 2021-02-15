package com.huang.curriculum.common.constans;

import lombok.Getter;

/***
 * url枚举类
 *
 * @author Created by Createsequence on 2019-12-11 16:21
 */
@Getter
public enum UrlEnum {

    /**
     * 登录
     */
    LOGIN_URL("http://jwxt.qlu.edu.cn/jsxsd/xk/LoginToXk"),

    /**
     * 获取当前学期
     */
    NOW_DATE_URL("http://jwxt.qlu.edu.cn/jsxsd/xsks/xsksap_query"),

    /**
     * 考试安排查询
     */
    EXAM_SCHEDULE_URL("http://jwxt.qlu.edu.cn/jsxsd/xsks/xsksap_list"),

    /**
     * 课程表查询
     */
    DAILY_SCHEDULE_URL("http://jwxt.qlu.edu.cn/jsxsd/xskb/xskb_list.do"),

    /**
     * 学习成绩查询
     */
    SCORE_URL("http://jwxt.qlu.edu.cn/jsxsd/kscj/cjcx_list");


    private String url;

    UrlEnum(String url) {
        this.url = url;
    }

}
