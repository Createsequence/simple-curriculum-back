package com.huang.curriculum.common.exception;

import com.huang.curriculum.common.result.CodeMsg;

/***
 * 用户登录异常
 *
 * @author Created by Createsequence on 2019-12-10 16:21
 */
public class UserLoginException extends CurriculumException {

    public UserLoginException(String msg) {
        super(msg);
    }

    public UserLoginException(int code, String msg) {
        super(code, msg);
    }

    public UserLoginException(CodeMsg codeMsg) {
        super(codeMsg);
    }
}
