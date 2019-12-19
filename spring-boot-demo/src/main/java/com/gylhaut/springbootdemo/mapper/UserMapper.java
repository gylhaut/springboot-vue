package com.gylhaut.springbootdemo.mapper;

import com.gylhaut.springbootdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  extends tk.mybatis.mapper.common.Mapper<User>{

    //public List<User> queryUserList();

}
