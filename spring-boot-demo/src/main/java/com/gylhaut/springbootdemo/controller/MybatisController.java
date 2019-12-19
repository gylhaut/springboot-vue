package com.gylhaut.springbootdemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gylhaut.springbootdemo.domain.User;
import com.gylhaut.springbootdemo.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RestController
@RequestMapping("mybatis")
@Api("Mybatis")
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("hello")
    @ApiOperation(httpMethod = "GET",value = "管理员登录" ,produces = MediaType.TEXT_HTML_VALUE,tags = "admin/zjk",notes = "参数")
    public String test(){
        return "hello ssm";
    }

    @GetMapping("query")
    @ResponseBody
    @ApiOperation(httpMethod = "GET",value = "管理员登录" ,produces = MediaType.TEXT_HTML_VALUE,tags = "admin/zjk",notes = "参数")
    public List<User> queryUserList(){
        List<User> users = userMapper.selectAll();
       // List<User> users = userMapper.queryUserList();
        return users;
    }


    @GetMapping("getUserList")
    @ApiOperation(httpMethod = "GET",value = "管理员登录" ,produces = MediaType.TEXT_HTML_VALUE,tags = "admin/zjk",notes = "参数")
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

    /**
     * 实现分页查询
     * @return
     */
    @RequestMapping("findUserByPage")
    @ApiOperation(httpMethod = "GET",value = "管理员登录" ,produces = MediaType.TEXT_HTML_VALUE,tags = "admin/zjk",notes = "参数")
    public List<User>  findUserByPage() {
        PageHelper.startPage(2,2);
        List<User> list =  userMapper.selectAll();
        PageInfo<User>  pageInfo = new PageInfo<>(list);
        List<User> pageList = pageInfo.getList();
        return pageList;

    }
}
