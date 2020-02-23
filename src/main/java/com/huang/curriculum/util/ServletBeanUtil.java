package com.huang.curriculum.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author：黄成兴
 * @Date：2020-01-16 15:50
 * @Description：<描述>
 */
public final class ServletBeanUtil {

    private ServletBeanUtil() {
    }

    /**
     * 自动匹配参数赋值到实体bean中
     *
     * @param bean    要转换的对象
     * @param request HttpServletRequest
     */
    public static void populate(Object bean, HttpServletRequest request) {

        Class<? extends Object> clazz = bean.getClass();
        //获取类中的所有方法
        Method[] ms = clazz.getDeclaredMethods();

        String mname;
        String field;
        String fieldType;
        String value;

        //遍历setter和getter方法
        for (Method m : ms) {
            //获取方法名
            mname = m.getName();
            //跳过set方法
            if (!mname.startsWith("set")
                    || ArrayUtils.isEmpty(m.getParameterTypes())) {
                continue;
            }
            try {
                //截取get方法，获取属性名
                field = mname.toLowerCase().charAt(3) + mname.substring(4, mname.length());
                //根据属性名从request里取出值
                value = request.getParameter(field);
                //如果取不到则跳过该属性
                if (StringUtils.isEmpty(value)) {
                    continue;
                }
                //获取属性类型
                fieldType = m.getParameterTypes()[0].getName();

                //将值转换为对应类型再赋值
                if (String.class.getName().equals(fieldType)) {
                    m.invoke(bean, value);
                } else if (Integer.class.getName().equals(fieldType) && NumberUtils.isDigits(value)) {
                    m.invoke(bean, Integer.valueOf(value));
                } else if (Short.class.getName().equals(fieldType) && NumberUtils.isDigits(value)) {
                    m.invoke(bean, Short.valueOf(value));
                } else if (Float.class.getName().equals(fieldType) && NumberUtils.isCreatable(value)) {
                    m.invoke(bean, Float.valueOf(value));
                } else if (Double.class.getName().equals(fieldType) && NumberUtils.isCreatable(value)) {
                    m.invoke(bean, Double.valueOf(value));
                } else if (Long.class.getName().equals(fieldType)) {
                    m.invoke(bean, Long.valueOf(value));
                } else if (Date.class.getName().equals(fieldType)) {
                    m.invoke(bean, DateUtils.parseDate(value, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"));
                } else if (LocalDateTime.class.getName().equals(fieldType)) {
                    m.invoke(bean, LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                } else if (Byte.class.getName().equals(fieldType)) {
                    m.invoke(bean, Byte.parseByte(value));
                } else {
                    //找不到类型处理方法
                    throw new RuntimeException("对象组装失败，无法处理的类型！（" + value + ")");
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

}
