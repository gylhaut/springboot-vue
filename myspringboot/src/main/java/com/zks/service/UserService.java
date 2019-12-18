package com.zks.service;

import com.zks.model.MyResult;
import com.zks.model.User;

/**
 * @author ：zhoukaishun
 * @date ：Created in 2019/5/9 9:38
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface UserService {
    MyResult login(User user);
}
