package com.zhb.blogs.service.impl;

import com.zhb.blogs.dao.UserDao;
import com.zhb.blogs.pojo.User;
import com.zhb.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        return user;
    }
}
