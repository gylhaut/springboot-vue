package com.gylhaut.springbootdemo;

import com.gylhaut.springbootdemo.domain.User;
import com.gylhaut.springbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void getTest() {
        User user = userService.queryById(1L);
        System.out.println(user);
    }
}
