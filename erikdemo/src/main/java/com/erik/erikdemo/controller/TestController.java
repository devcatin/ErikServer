package com.erik.erikdemo.controller;

import com.erik.erikdemo.base.Result;
import com.erik.erikdemo.base.ResultCode;
import com.erik.erikdemo.bean.Banner;
import com.erik.erikdemo.bean.UserBean;
import com.erik.erikdemo.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class TestController {

    @Autowired
    private EnterService enterService;

    @GetMapping(value = "user/query")
    public Result getUserList() {

        List<UserBean> list = enterService.getUserList();

        if (list != null) {
            return Result.success(list);
        } else  {
            return Result.failure(ResultCode.FAILURE);
        }
    }

    @RequestMapping(value = "user/getUserInfo")
    @ResponseBody
    public Result getUserInfo(Integer id) {

        UserBean userBean = enterService.getUserInfo(id);

        if (userBean != null) {
            return Result.success(userBean);
        } else {
            return Result.failure(ResultCode.FAILURE);
        }
    }

    @RequestMapping(value = "user/add")
    @ResponseBody
    public Result add(UserBean userBean) {

        Integer code = enterService.add(userBean);

        if (code > 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.FAILURE);
        }
    }

    @RequestMapping(value = "user/delete")
    @ResponseBody
    public Result delete(Integer id) {
        Integer code = enterService.delete(id);
        if (code > 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.FAILURE);
        }
    }

    @RequestMapping(value = "user/update")
    @ResponseBody
    public Result delete(Integer id, UserBean userBean) {

        Integer code = enterService.update(id, userBean);

        if (code > 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.FAILURE);
        }
    }

    @RequestMapping(value = "home/getBannerList")
    @ResponseBody
    public Result getBannerList() {

        List<Banner> list = enterService.getBannerList();

        if (list != null) {
            return Result.success(list);
        } else  {
            return Result.failure(ResultCode.FAILURE);
        }
    }


}
