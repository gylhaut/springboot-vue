package com.gylhaut.springbootdemo.service;

import com.gylhaut.springbootdemo.domain.User;

import java.util.List;

public interface UserService {

    public User queryById(Long id);

    public void deleteById(Long id);

    List<User> queryAll();
}
