package com.huang.curriculum.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * @Author：黄成兴
 * @Date：2019-12-10 17:38
 * @Description：加密工具
 */
public class EncryptionUtils {

    /**
     * js方法接口
     */
    public interface Method{
        public String encodeInp(String input);
    }

    /**
     *  Java执行JavaScript脚本破解加密算法
     * @param str
     * @return 加密后的字符串
     */
    public static String encryptionJs(String str) {
        // 创建一个脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        // 获取一个指定的名称的脚本引擎
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            //获取resources文件
            Resource resource = new ClassPathResource("static/conwork.js");
            // FileReader的参数为所要执行的js文件的路径（对空格进行处理）
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
