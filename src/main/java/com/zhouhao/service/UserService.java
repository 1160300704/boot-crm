package com.zhouhao.service;

import com.zhouhao.po.User;

public interface UserService {
    public User findUser(String userCode, String userPassword);
}
