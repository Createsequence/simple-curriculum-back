package com.huang.curriculum.common.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 响应类
 */
@Getter
@Setter
@ToString
public class CodeMsg {

    /**
     * 状态（success 或 error）
     */
    private String status;
    /**
     * 错误代码
     */
    private int code;
    /**
     * 信息
     */
    private String msg;

    //通用
    public static CodeMsg SUCCESS = new CodeMsg("success", 1 , "请求成功");
    public static CodeMsg ERROR = new CodeMsg("error" ,0, "请求失败");

    public CodeMsg(String status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

}
