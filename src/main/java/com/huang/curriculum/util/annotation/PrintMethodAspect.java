package com.huang.curriculum.util.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-01-13 12:21
 * @Description：用于MethodLogAnnotation注解的aop
 */
@Aspect
@Component
public class PrintMethodAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //程序开始时间
    private long startTime;
    //程序结束时间
    private long endTime;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.huang.curriculum.util.annotation.PrintMethod)")
    public void annotationPointcut() {

    }

    /**
     * 执行前
     *
     * @param joinPoint
     */
    @Before("annotationPointcut()")
    public void beforPointcut(JoinPoint joinPoint) {
        //获取开始时间
        startTime = System.currentTimeMillis();

        printAnnotationValue(joinPoint, true);

    }

    /**
     * 执行后
     *
     * @param joinPoint
     */
    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        //获取程序结束时间
        endTime = System.currentTimeMillis();

        printAnnotationValue(joinPoint, false);
    }

    /**
     * 根据条件输出方法执行情况
     *
     * @param joinPoint 切入点
     * @param isBefore  是否为切点前执行方法
     */
    private void printAnnotationValue(JoinPoint joinPoint, boolean isBefore) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        //获取注解上的参数
        PrintMethod annotation = method.getAnnotation(PrintMethod.class);
        boolean printParams = annotation.printParams();
        String value = annotation.value();
        Object[] params = joinPoint.getArgs();

        //如果没注明方法，则默认输出方法名
        if ("".equals(value)) {
            value = method.getName();
        }

        if (isBefore) {
            //执行前方法
            logger.info("================开始执行{}================", value);
            //是否要打印参数
            if (printParams) {
                String str = Arrays.toString(params);
                logger.info("参数：{}", str);
            }
        } else {
            //执行后方法
            logger.info("================结束执行{}，运行时间：{}ms================", value, (endTime - startTime));
        }

    }

}
