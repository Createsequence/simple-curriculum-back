package com.huang.curriculum.component;

import com.huang.curriculum.common.constans.CodeMsgEnmu;
import com.huang.curriculum.common.exception.UserLoginException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：黄成兴
 * @Date：2020-02-25 10:00
 * @Description：用于service接口数据检验
 */
public final class CheckComponent {

    /**
     * 检验jsessionId
     * @param jsessionId 从教务系统获取的jsessionid
     * @return
     */
    public static String checkJessionId(String jsessionId){
        //如果没有cookie则视为未登录
        if (jsessionId == null || "null".equals(jsessionId.trim())){
            throw new UserLoginException(CodeMsgEnmu.NOT_LOGIN_ERROR.getCodeMsg());
        }
        //返回jsessionId
        return jsessionId;
    }

    /**
     * 检验获取的网页信息是否包含错误提示
     * @param document
     */
    public static void checkResponse(Document document){
        //获取报错标签，如果存在则抛出错误
        Element tipEle = document.select("form div.dlmi font").first();
        if (tipEle != null || document.text().contains("请先登录系统")) {
            throw new UserLoginException(CodeMsgEnmu.COOKIE_EXPIRED_ERROR.getCodeMsg());
        }
    }

}
