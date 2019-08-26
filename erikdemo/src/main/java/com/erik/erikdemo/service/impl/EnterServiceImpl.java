package com.erik.erikdemo.service.impl;

import com.erik.erikdemo.bean.Banner;
import com.erik.erikdemo.bean.ClassBean;
import com.erik.erikdemo.bean.LiveBean;
import com.erik.erikdemo.bean.UserBean;
import com.erik.erikdemo.dao.HomeDao;
import com.erik.erikdemo.dao.UserDao;
import com.erik.erikdemo.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterServiceImpl implements EnterService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HomeDao homeDao;

    @Override
    public List<UserBean> getUserList(Integer pageIndex, Integer pageSize) {
        return userDao.getUserList(pageIndex, pageSize);
    }

    @Override
    public UserBean getUserInfo(Integer id) {
        return userDao.getUserInfo(id);
    }

    @Override
    public int add(UserBean userBean) {
        return userDao.add(userBean);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public int update(Integer id, UserBean userBean) {
        return userDao.update(id, userBean);
    }

    @Override
    public List<Banner> getBannerList() {
        return homeDao.getBannerList();
    }

    @Override
    public List<ClassBean> getClassList() {
        return homeDao.getClassList();
    }

    @Override
    public List<LiveBean> getLiveList() {
        return homeDao.getLiveList();
    }

}
