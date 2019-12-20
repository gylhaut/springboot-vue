package com.gylhaut.springbootdemo.service;

import com.gylhaut.springbootdemo.domain.User;

import java.util.List;

public interface UserService {

     int insertUser(User u);

     User queryById(Long id);

     void deleteById(Long id);

     List<User> queryAll();
}
