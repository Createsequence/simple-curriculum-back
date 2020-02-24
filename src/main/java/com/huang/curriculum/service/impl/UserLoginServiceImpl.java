package com.huang.curriculum.service.impl;

import com.huang.curriculum.common.constans.UrlEnum;
import com.huang.curriculum.common.exception.UserLoginException;
import com.huang.curriculum.pojo.dto.User;
import com.huang.curriculum.service.UserLoginService;
import com.huang.curriculum.util.EncryptionUtils;
import com.huang.curriculum.util.JsoupUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：黄成兴
 * @Date：2020-02-24 9:23
 * @Description：教务系统登录接口实现类
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Map<String, String> loginSystem(User user) {
        //获取账号密码
        String userAccount = user.getUserAccount();
        String userPassword = user.getUserPassword();
        //合成验证码
        String encoded = EncryptionUtils.encryptionJs(userAccount) + "%%%" + EncryptionUtils.encryptionJs(userPassword);
        if (encoded.contains("IA==") || encoded.contains("null")){
            throw new UserLoginException("用户名或密码不能为空！");
        }

        //封装登录信息
        Map<String, String> loginDate = new HashMap<>(3);
        loginDate.put("userAccount", userAccount);
        loginDate.put("userPassword", userPassword);
        loginDate.put("encoded", encoded);

        logger.info("userAccount：{}，userPassword：{}",userAccount, userPassword);
        logger.info("合成验证码：{}", encoded);

        //执行请求并获取响应信息
        String url = UrlEnum.LOGIN_URL.getUrl();
        Connection.Response response = JsoupUtils.getResponse(url ,loginDate, null);

        //获取页面文档
        Document document = Jsoup.parseBodyFragment(response.body());
        //获取报错标签
        Element tipEle = document.select("form div.dlmi font").first();

        //判断是否登录成功
        if (tipEle == null){
            //登录成功，获取cookie
            Map<String, String> cookie = response.cookies();
            logger.info("登录成功！获取cookie:{}",cookie);
            return cookie;
        }else {
            //登录失败，抛出异常
            logger.info("登录失败");
            throw new UserLoginException(tipEle.text());
        }
    }

}
