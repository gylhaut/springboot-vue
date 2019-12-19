package com.gylhaut.springbootdemo.service;

import com.gylhaut.springbootdemo.domain.User;

public interface UserService {

    public User queryById(Long id);

    public void deleteById(Long id);
}
