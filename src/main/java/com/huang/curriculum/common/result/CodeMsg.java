package com.huang.curriculum.common.result;

import com.huang.curriculum.common.constans.Constans;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 响应类
 *
 * @author Created by Createsequence on 2021/2/15 16:46
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
    
    /**
     * 请求成功
     */
    public static final CodeMsg SUCCESS = new CodeMsg(Constans.SUCCESS, 1 , "请求成功");
    
    /**
     * 请求失败
     */
    public static final CodeMsg ERROR = new CodeMsg(Constans.ERROR ,0, "请求失败");

    public CodeMsg(String status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

}
