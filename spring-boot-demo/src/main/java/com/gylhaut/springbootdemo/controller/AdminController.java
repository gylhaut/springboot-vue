package com.gylhaut.springbootdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
@Api(tags ="登录测试")
public class AdminController {

    @ApiOperation("登录测试")
    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }
}