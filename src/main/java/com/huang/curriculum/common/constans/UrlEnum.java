package com.huang.curriculum.common.constans;

import lombok.Getter;

/**
 * @Author：黄成兴
 * @Date：2019-12-11 15:47
 * @Description：url枚举类
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

    private UrlEnum(String url) {
        this.url = url;
    }

}
