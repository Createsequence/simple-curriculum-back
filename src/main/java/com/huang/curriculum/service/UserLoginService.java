package com.huang.curriculum.service;

import com.huang.curriculum.pojo.dto.User;

import java.util.Map;

/**
 * @Author：黄成兴
 * @Date：2020-02-24 9:20
 * @Description：教务系统登录接口
 */
public interface UserLoginService {

    /**
     * 登录教务系统
     * @param user 用户学号密码
     * @return 从教务系统获取的cookie
     */
    public Map<String, String> loginSystem(User user);

}
