package com.huang.curriculum.common.result;

import lombok.Getter;

/**
 * 结果封装
 */
@Getter
public class Result<T> {

    private String status;
    private Integer code;
    private String msg;
    private T data;


    /**
     * 成功时调用
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data,CodeMsg.SUCCESS);
    }

    public static <T> Result<T> success(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }

    public static <T> Result<T> success(String msg) {
        return success(new CodeMsg("success",1, msg));
    }

    public static <T> Result<T> success() {
        return success(CodeMsg.SUCCESS);
    }

    /**
     * 失败时调用
     */
    public static <T> Result<T> error(T data) {
        return new Result<T>(data,CodeMsg.ERROR);
    }

    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }

    public static <T> Result<T> error(String msg) {
        return success(new CodeMsg("error",0, msg));
    }

    public static <T> Result<T> error() {
        return error(CodeMsg.ERROR);
    }

    /**
     * 返回带数据的结果
     * @param data 数据
     * @param msg CodeMsg
     */
    private Result(T data ,CodeMsg msg) {
        this.status = msg.getStatus();
        this.code = msg.getCode();
        this.msg = msg.getMsg();
        this.data = data;
    }

    /**
     * 返回不带数据的结果
     * @param msg CodeMsg
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
