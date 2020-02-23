package com.huang.curriculum.util.annotation;

import java.lang.annotation.*;

/**
 * @Author：黄成兴
 * @Date：2020-01-13 12:13
 * @Description：自定义注解，标记方法，并打印方法的名称，参数和执行情况
 */
//只作用方法
@Target(ElementType.METHOD)
//生命周期为程序运行期
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrintMethod {

    //方法的执行功能
    String value() default "";

    //是否打印参数列表
    boolean printParams() default true;

}
