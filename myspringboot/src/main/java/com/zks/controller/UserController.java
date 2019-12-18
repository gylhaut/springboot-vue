package com.zks.controller;

import com.zks.model.MyResult;
import com.zks.model.User;
import com.zks.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：zhoukaishun
 * @date ：Created in 2019/5/9 9:36
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @ResponseBody
    @PostMapping("/login")
    public MyResult login(@RequestBody User user){
        return userService.login(user);
    }


    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        System.out.println("123456");
        return "123";
    }
}
