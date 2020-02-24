package com.huang.curriculum.controller;

import com.huang.curriculum.common.result.Result;
import com.huang.curriculum.pojo.dto.User;
import com.huang.curriculum.pojo.vo.CourseSchedule;
import com.huang.curriculum.service.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：黄成兴
 * @Date：2020-02-24 10:48
 * @Description：用户操作接口
 */
@Api("用户操作接口")
@RequestMapping("/user/")
@RestController
public class UserController {

    @Autowired
    UserLoginService userLoginService;

    @ApiOperation("用户登录，获取cookie")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名", name = "userAccount", required = true),
            @ApiImplicitParam(value = "密码", name = "userPassword", required = true)
    })
    @PostMapping("login")
    public Result Login(@RequestParam String userAccount,
                        @RequestParam String userPassword){
        User user = new User()
                .setUserAccount(userAccount)
                .setUserPassword(userPassword);
        //登录并获取cookie
        Map<String, String> cookie = userLoginService.loginSystem(user);

        return Result.success(cookie);
    }

}
