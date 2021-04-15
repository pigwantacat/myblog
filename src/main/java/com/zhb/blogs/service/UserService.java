package com.zhb.blogs.service;

import com.zhb.blogs.pojo.User;

public interface UserService {
    User findUserByUsername(String username);
}
