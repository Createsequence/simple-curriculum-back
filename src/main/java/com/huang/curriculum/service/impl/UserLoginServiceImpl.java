package com.huang.curriculum.service.impl;

import com.huang.curriculum.common.constans.Constans;
import com.huang.curriculum.common.constans.UrlEnum;
import com.huang.curriculum.common.exception.UserLoginException;
import com.huang.curriculum.pojo.dto.User;
import com.huang.curriculum.service.UserLoginService;
import com.huang.curriculum.common.util.EncryptionUtils;
import com.huang.curriculum.common.util.JsoupUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/***
 * 教务系统登录接口实现类
 *
 * @author Created by Createsequence on 2020-02-24 9:23
 */
@Slf4j
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Override
    public Map<String, String> loginSystem(User user) {
        //获取账号密码
        String userAccount = user.getUserAccount();
        String userPassword = user.getUserPassword();
        //合成验证码
        String encoded = EncryptionUtils.encryptionJs(userAccount) + "%%%" + EncryptionUtils.encryptionJs(userPassword);
        if (encoded.contains(Constans.EMPTY_ENCODED_KEY) || encoded.contains(Constans.NULL)){
            throw new UserLoginException("用户名或密码不能为空！");
        }

        //封装登录信息
        Map<String, String> loginDate = new HashMap<>(3);
        loginDate.put("userAccount", userAccount);
        loginDate.put("userPassword", userPassword);
        loginDate.put("encoded", encoded);

        log.info("userAccount：{}，userPassword：{}",userAccount, userPassword);
        log.info("合成验证码：{}", encoded);

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
            log.info("登录成功！获取cookie:{}",cookie);

            //获取用户名
            Element userInfo = document.select(".wap .block1 .block1text").get(0);
            String userName = userInfo.text().split(" ")[0].substring(3);
            cookie.put("userName", userName);

            return cookie;
        }else {
            //登录失败，抛出异常
            log.info("登录失败");
            throw new UserLoginException(tipEle.text());
        }
    }

}
