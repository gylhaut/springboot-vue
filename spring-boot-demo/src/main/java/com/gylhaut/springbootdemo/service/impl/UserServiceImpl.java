package com.gylhaut.springbootdemo.service.impl;

import com.gylhaut.springbootdemo.domain.User;
import com.gylhaut.springbootdemo.mapper.UserMapper;
import com.gylhaut.springbootdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.userMapper.deleteByPrimaryKey(id);
    }
}
