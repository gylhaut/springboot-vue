package com.gylhaut.springbootdemo.service.impl;

import com.gylhaut.springbootdemo.domain.User;
import com.gylhaut.springbootdemo.mapper.UserMapper;
import com.gylhaut.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User u) {
//        User us = new User();
//        us.setName("张明");
//        us.setUsername("zhangming");
//        us.setPassword("7899");
        return  userMapper.insert(u);
    }

    @Override
    public User queryById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.userMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<User> queryAll()
    {
        return userMapper.selectAll();
    }


}
