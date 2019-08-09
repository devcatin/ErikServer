package com.erik.erikdemo.service.impl;

import com.erik.erikdemo.bean.UserBean;
import com.erik.erikdemo.dao.UserDao;
import com.erik.erikdemo.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterServiceImpl implements EnterService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserBean> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public UserBean getUserInfo(Integer id) {
        return userDao.getUserInfo(id);
    }

}
