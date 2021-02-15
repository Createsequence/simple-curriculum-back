package com.huang.curriculum.common.constans;

import com.huang.curriculum.common.result.CodeMsg;
import lombok.Getter;

/***
 * 返回信息枚举类
 *
 * @author Created by Createsequence on 2019-12-11 16:21
 */
@Getter
public enum CodeMsgEnmu {

    /**
     * 用户未登录
     */
    NOT_LOGIN_ERROR(new CodeMsg(Constans.ERROR, 1001 , "用户未登录!")),

    /**
     * 登录参数错误
     */
    ILLEGAL_LOGIN_PARAMS_ERROR(new CodeMsg(Constans.ERROR, 1002 , "登录参数错误!")),

    /**
     * cookie过期错误
     */
    COOKIE_EXPIRED_ERROR(new CodeMsg(Constans.ERROR, 1003 , "cookie已过期，重新登录!"));

    private CodeMsg codeMsg;

    CodeMsgEnmu(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }
}
