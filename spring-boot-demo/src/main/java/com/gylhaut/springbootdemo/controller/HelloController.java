package com.gylhaut.springbootdemo.controller;

import com.gylhaut.springbootdemo.domain.User;
import com.gylhaut.springbootdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 整合前端模板thymeleaf
 */
@Controller
@Api(tags="Hello测试")
public class HelloController {

    @Autowired
    private UserService userService;



    @ApiOperation(value = "thymeleaf测试")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(HttpServletRequest request,
                        @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }
    @ApiOperation(value = "查询列表展示")
    @GetMapping("all")
    public String all(ModelMap model){
        //查询用户
        List<User> users = this.userService.queryAll();

        //放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }

}