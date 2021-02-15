package com.huang.curriculum.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * WebMvc配置类
 *
 * @author Created by Createsequence on 2020-02-07 16:23
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 处理AJAX请求跨域的问题，目前暂且不进行跨域处理
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

}
