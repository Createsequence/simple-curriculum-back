package com.huang.curriculum.common.exception;

import com.huang.curriculum.common.result.CodeMsg;

/**
 * @Author：黄成兴
 * @Date：2019-12-10 23:45
 * @Description：用户登录异常
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
