package com.huang.simple_curriculum.simple_curriculum;

import com.huang.curriculum.SimpleCurriculumApplication;
import com.huang.curriculum.pojo.dto.User;
import com.huang.curriculum.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleCurriculumApplication.class)
class SimpleCurriculumApplicationTests {

    @Autowired
    UserLoginService userLoginService;

    @Test
    void contextLoads() {
        userLoginService.loginSystem(new User());
    }

}
