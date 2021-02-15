package com.huang.curriculum.service;

import com.huang.curriculum.pojo.dto.User;

import java.util.Map;

/***
 * 教务系统登录接口
 *
 * @author Created by Createsequence on 2020-02-24 16:43
 */
public interface UserLoginService {

    /***
     * 登录教务系统
     *
     * @param user 用户学号密码
     * @return java.util.List<com.huang.curriculum.pojo.vo.ExamSchedule> 从教务系统获取的cookie
     * @author Created by Createsequence on 2020-02-24 16:43
     */
    Map<String, String> loginSystem(User user);

}
