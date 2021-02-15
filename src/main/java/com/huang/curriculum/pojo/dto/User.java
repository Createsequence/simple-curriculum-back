package com.huang.curriculum.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/***
 * 登录用户实体类
 *
 * @author Created by Createsequence on 2019-12-10 16:40
 */
@Accessors(chain = true)
@Getter
@Setter
public class User {

    /**
     * 用户登录账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 验证码
     */
    private String userSafeCode;

}
