package com.zhouhao.service.impl;

import com.zhouhao.dao.UserDao;
import com.zhouhao.po.User;
import com.zhouhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String userCode, String userPassword) {
        User user = userDao.findUser(userCode, userPassword);
        return user;
    }
}
