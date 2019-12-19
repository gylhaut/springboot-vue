package com.gylhaut.springbootdemo.controller;

import com.gylhaut.springbootdemo.domain.User;
import com.gylhaut.springbootdemo.mapper.UserMapper;
import com.gylhaut.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RestController
@RequestMapping("user")
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    @GetMapping("hello")
    public String test(){
        return "hello ssm";
    }

    @GetMapping("query")
    @ResponseBody
    public List<User> queryUserList(){
        List<User> users = userMapper.selectAll();
       // List<User> users = userMapper.queryUserList();
        return users;
    }

    @GetMapping("queryById")
    public User queryById(){
       return userService.queryById(1L);
    }

    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id")Long id){
        return this.userService.queryById(id);
    }



    @GetMapping("deleteById")
    public void deleteById(Long id){
         userService.deleteById(2L);
    }

    @GetMapping("getUserList")
    public  List<User>  getUserList(){
        // 创建Example
        Example example = new Example(User.class);
        // 创建Criteria
        Example.Criteria criteria = example.createCriteria();
        // 添加条件
        criteria.andEqualTo("username", "lisi");
        criteria.andLike("name", "%李%");
        List<User> list = userMapper.selectByExample(example);
        return list;

    }

}
