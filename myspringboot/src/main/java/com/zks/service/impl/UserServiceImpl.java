package com.zks.service.impl;

import com.zks.dao.UserDao;
import com.zks.model.MyResult;
import com.zks.model.User;
import com.zks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhoukaishun
 * @date ：Created in 2019/5/9 9:42
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public MyResult login(User user) {
        User u = null;
        List<User> list = new ArrayList<User>();
        u = userDao.login(user);
        MyResult result = new MyResult();
        if(u!=null){
            result.setCode(0);
            result.setMsg("登陆成功！");
            list.add(u);
            result.setList(list);
        }else{
            result.setCode(1);
            result.setMsg("登陆失败！");
        }
        return result;

    }
}
