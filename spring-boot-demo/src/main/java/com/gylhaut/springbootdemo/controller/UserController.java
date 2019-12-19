package com.gylhaut.springbootdemo.controller;

import com.gylhaut.springbootdemo.domain.User;
import com.gylhaut.springbootdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Swagger UI整合操作
 */

@RestController
@Api(tags="管理员操作")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation("根据id查询用户的接口")
    @RequestMapping(value = "queryUserById/{id}",method = RequestMethod.GET)
    public User queryUserById(@PathVariable("id")Long id){
        return this.userService.queryById(id);
    }


    @ApiOperation(value = "管理员登录")
    @GetMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
    }

}

