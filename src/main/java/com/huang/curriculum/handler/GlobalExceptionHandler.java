package com.huang.curriculum.handler;

import com.huang.curriculum.common.exception.UserLoginException;
import com.huang.curriculum.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理器
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用户登录异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public Result userLoginExceptionHandler(UserLoginException e){
        e.printStackTrace();
        log.error(e.getCodeMsg().getMsg());
        return Result.error(e.getCodeMsg());
    }

    /**
     * 运行异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result runtimeExceptionHandler(RuntimeException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.error(e.getMessage());
    }

}
