package com.huang;

import com.huang.curriculum.SimpleCurriculumApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 外部tomcat启动类
 * @author 黄成兴
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        //找到原先的启动类
        return application.sources(SimpleCurriculumApplication.class);
    }
}
