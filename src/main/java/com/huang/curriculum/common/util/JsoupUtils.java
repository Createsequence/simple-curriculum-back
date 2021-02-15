package com.huang.curriculum.common.util;

import com.huang.curriculum.common.exception.CurriculumException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * Jsoup工具类
 *
 * @author Created by Createsequence on 2020-02-24 16:35
 */
public final class JsoupUtils {

    private JsoupUtils() {
        throw new CurriculumException("工具类不允许实例化");
    }

    /***
     * 根据数据和url获得响应信息（默认请求方法为post）
     *
     * @param url 请求的url
     * @param formDate 提交的表单数据
     * @param cookie cookie
     * @return org.jsoup.Connection.Response
     * @author Created by Createsequence on 2020-02-24 16:35
     */
    public static Connection.Response getResponse(String url , Map<String ,String> formDate, Map<String, String> cookie){

        //装填响应头
        Connection connection = Jsoup.connect(url)
                .header("Host", "jwxt.qlu.edu.cn")
                .header("Accept", "application/json, text/javascript, */*; q=0.01")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Connection", "keep-alive")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0")
                .header("X-Requested-With", "XMLHttpRequest");

        //装填表单数据
        if (null != formDate){
            connection.data(formDate);
        }

        //装入cookie
        if (null != cookie){
            connection.cookies(cookie);
        }

        //执行请求并获取响应信息
        Connection.Response response;
        try {
            response = connection
                    .ignoreContentType(true)
                    .method(Connection.Method.POST)
                    .execute();
        } catch (IOException e) {
            throw new CurriculumException("获取响应信息失败！");
        }
    
        if (response == null) {
            throw new CurriculumException("获取响应信息失败！");
        }
        
        return response;
    }

    /**
     * 请求url，并将response获得的html页面转换为JsoupDocument
     *
     * @param url 请求的url
     * @param formDate 提交的表单数据
     * @param cookie cookie
     * @return org.jsoup.nodes.Document
     * @author Created by Createsequence on 2020-02-24 16:36
     */
    public static Document getJsoupDocument(String url , Map<String ,String> formDate, Map<String, String> cookie){
        String responseBody = "";
        Connection.Response response = getResponse(url, formDate, cookie);
        if (response != null) {
            responseBody = response.body();
        }
        return Jsoup.parseBodyFragment(responseBody);
    }

    /**
     * 从一个父标签集合中，提取每一个父标签的子集合，将子集合组成新集合并返回
     * 
     * @param elements 元素集合
     * @param skipFirst 是否跳过第一行
     * @return java.util.List<org.jsoup.select.Elements>
     * @author Created by Createsequence on 2020-02-24 16:36
     */
    public static List<Elements> getElementsChildrens(Elements elements , Boolean skipFirst){

        if (elements == null || elements.size() <= 1){
            throw new CurriculumException("没有需要转换的集合！");
        }

        //是否跳过标题行
        if (skipFirst){
            elements.remove(0);
        }

        //提取集合
        return elements.stream()
                //将结果集映射为子集合
                .map(Element::children)
                .collect(Collectors.toList());
    }

}
