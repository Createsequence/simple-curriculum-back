package com.huang.curriculum.common.result;

import com.huang.curriculum.common.constans.Constans;
import lombok.Getter;

/***
 * 响应类
 *
 * @author Created by Createsequence on 2020-02-24 16:34
 */
@Getter
public class Result {

    private String status;
    private Integer code;
    private String msg;
    private Object data;


    /**
     * 成功时调用
     */
    public static Result success(Object data) {
        return new Result(data, CodeMsg.SUCCESS);
    }

    public static Result success(CodeMsg codeMsg) {
        return new Result(codeMsg);
    }

    public static Result success(String msg) {
        return success(new CodeMsg(Constans.SUCCESS,1, msg));
    }

    public static Result success() {
        return success(CodeMsg.SUCCESS);
    }

    /**
     * 失败时调用
     */
    public static Result error(Object data) {
        return new Result(data, CodeMsg.ERROR);
    }

    public static Result error(CodeMsg codeMsg) {
        return new Result(codeMsg);
    }

    public static Result error(String msg) {
        return success(new CodeMsg(Constans.ERROR,0, msg));
    }

    public static Result error() {
        return error(CodeMsg.ERROR);
    }

    /***
     * @param data 数据
     * @param msg CodeMsg
     * @author Created by Createsequence on 2020-02-24 16:34
     */
    private Result(Object data ,CodeMsg msg) {
        this.status = msg.getStatus();
        this.code = msg.getCode();
        this.msg = msg.getMsg();
        this.data = data;
    }
    
    /***
     * @param msg CodeMsg
     * @author Created by Createsequence on 2020-02-24 16:34
     */
    private Result(CodeMsg msg) {
        if ( msg == null ) {
            return;
        }
        this.status = msg.getStatus();
        this.code = msg.getCode();
        this.msg = msg.getMsg();
    }
}
