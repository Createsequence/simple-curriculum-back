package com.huang.curriculum.common.handler;

import com.huang.curriculum.common.exception.CurriculumException;
import com.huang.curriculum.common.exception.UserLoginException;
import com.huang.curriculum.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 统一异常处理器
 *
 * @author Created by Createsequence on 2021/2/15 16:23
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /***
     * 用户登录异常处理
     *
     * @param e 异常
     * @return com.huang.curriculum.common.result.Result
     * @author Created by Createsequence on 2020-02-24 16:24
     */
    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public Result userLoginExceptionHandler(UserLoginException e){
        e.printStackTrace();
        log.error(e.getCodeMsg().getMsg());
        return Result.error(e.getCodeMsg());
    }
    
    /***
     * 系统异常处理
     *
     * @param e 异常
     * @return com.huang.curriculum.common.result.Result
     * @author Created by Createsequence on 2020-02-24 16:24
     */
    @ExceptionHandler(CurriculumException.class)
    @ResponseBody
    public Result curriculumExceptionHandler(CurriculumException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.error(e.getMessage());
    }
    
    /***
     * 异常处理
     *
     * @param e 异常
     * @return com.huang.curriculum.common.result.Result
     * @author Created by Createsequence on 2020-02-24 16:24
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result runtimeExceptionHandler(RuntimeException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.error(e.getMessage());
    }

}
