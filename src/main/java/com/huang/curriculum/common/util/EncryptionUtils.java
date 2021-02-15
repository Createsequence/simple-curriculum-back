package com.huang.curriculum.common.util;

import com.huang.curriculum.common.exception.CurriculumException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/***
 * 加密工具类
 *
 * @author Created by Createsequence on 2019-12-10 16:18
 */
public final class EncryptionUtils {

    public EncryptionUtils() {
        throw new CurriculumException("工具类不允许实例化");
    }

    /**
     * js方法接口
     */
    public interface Method{
        String encodeInp(String input);
    }

    /***
     * JavaScript脚本破解加密算法
     *
     * @param str 账号密码字符串
     * @return java.lang.String
     * @author Created by Createsequence on 2019-12-10 16:18
     */
    public static String encryptionJs(String str) {
        // 创建一个脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        // 获取一个指定的名称的脚本引擎
        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
            //获取resources文件
            Resource resource = new ClassPathResource("static/conwork.js");
            //读取js并调用方法（路径bug，暂不可用）
            engine.eval(new FileReader(resource.getFile()));
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                // 从脚本引擎中返回一个给定接口的实现
                Method executeMethod = invocable.getInterface(Method.class);
                // 执行指定的js方法
                return executeMethod.encodeInp(str);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return null;
    }


}
