package com.huang.curriculum.common.util;

import com.huang.curriculum.common.constans.CodeMsgEnmu;
import com.huang.curriculum.common.constans.Constans;
import com.huang.curriculum.common.exception.CurriculumException;
import com.huang.curriculum.common.exception.UserLoginException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/***
 * 数据校验工具类
 *
 * @author Created by Createsequence on 2020-02-25 10:00
 */
public final class CheckUtils {
    
    private CheckUtils() {
        throw new CurriculumException("工具类不允许实例化");
    }
    
    /***
     * 校验JessionId
     *
     * @param jsessionId 教务管理系统获取的JessionId
     * @return java.lang.String
     * @author Created by Createsequence on 2020-02-25 16:17
     */
    public static String checkJessionId(String jsessionId){
        //如果没有cookie则视为未登录
        if (jsessionId == null || Constans.NULL.equals(jsessionId.trim())){
            throw new UserLoginException(CodeMsgEnmu.NOT_LOGIN_ERROR.getCodeMsg());
        }
        //返回jsessionId
        return jsessionId;
    }

    /***
     * 检验获取的网页信息是否包含错误提示
     *
     * @param document Jsoup获取的文档对象
     * @author Created by Createsequence on 2020-02-25 16:17
     */
    public static void checkResponse(Document document){
        //获取报错标签，如果存在则抛出错误
        Element tipEle = document.select("form div.dlmi font").first();
        if (tipEle != null || document.text().contains(Constans.LOGIN_TIP)) {
            throw new UserLoginException(CodeMsgEnmu.COOKIE_EXPIRED_ERROR.getCodeMsg());
        }
    }

}
