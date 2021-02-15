package com.huang.curriculum.common.exception;

import com.huang.curriculum.common.result.CodeMsg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 自定义异常，所有异常需继承此类
 * @author Created by Createsequence on 2019-12-11 16:19
 */
@Getter
@Setter
@ToString
public class CurriculumException extends RuntimeException{

    /**
     * 返回信息类
     */
    private final CodeMsg codeMsg;

    /**
     * 接受错误信息
     */
    public CurriculumException(String msg) {
        super(msg);
        this.codeMsg = new CodeMsg("error" ,0 ,msg);
    }

    /**
     * 接受状态码和错误信息
     */
    public CurriculumException(int code , String msg) {
        super(msg);
        this.codeMsg = new CodeMsg("error" ,code ,msg);
    }

    /**
     * 接收返回信息类
     */
    public CurriculumException(CodeMsg codeMsg) {
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
    }

}
