package com.erik.erikdemo.service;

import com.erik.erikdemo.bean.Banner;
import com.erik.erikdemo.bean.ClassBean;
import com.erik.erikdemo.bean.LiveBean;
import com.erik.erikdemo.bean.UserBean;

import java.util.List;

public interface EnterService {

    List<UserBean> getUserList(int pageIndex, int pageSize);

    UserBean getUserInfo(int id);

    int add(UserBean userBean);

    int delete(int id);

    int update(int id, UserBean userBean);

    List<Banner> getBannerList();

    List<ClassBean> getClassList();

    List<LiveBean> getLiveList();

}
