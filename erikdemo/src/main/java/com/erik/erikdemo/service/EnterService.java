package com.erik.erikdemo.service;

import com.erik.erikdemo.bean.UserBean;

import java.util.List;

public interface EnterService {

    List<UserBean> getUserList();

    UserBean getUserInfo(Integer id);

}
