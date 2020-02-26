# 简单课程表后台

#### 介绍
基于springboot和jsoup，为简单课程表APP提供数据的后台

#### 软件架构
~~~xml
|--com.huang.curriculum
   |--common //公共资源，包括响应类，枚举类和自定义的Exception
   |--component //通用组件
   |--config //配置
   |--controller //控制器
   |--handler //拦截器
   |--pojo //实体类
   |--service //业务接口
~~~




#### 安装教程

1.  导出项目后添加至Maven管理，添加依赖
2.  运行SimpleCurriculumApplication启动类启动，或者添加至tomcat容器启动皆可

#### 使用说明

本项目只针对志强教务系统有效，所有数据都通过jsoup爬取，本身不涉及任何数据的存储