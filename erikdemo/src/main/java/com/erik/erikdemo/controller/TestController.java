package com.erik.erikdemo.controller;

import com.erik.erikdemo.base.Result;
import com.erik.erikdemo.base.ResultCode;
import com.erik.erikdemo.bean.Banner;
import com.erik.erikdemo.bean.ClassBean;
import com.erik.erikdemo.bean.LiveBean;
import com.erik.erikdemo.bean.UserBean;
import com.erik.erikdemo.service.EnterService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
public class TestController {

    @Autowired
    private EnterService enterService;

    private static int pageSize = 5;
    private static int pageIndex = 1;

    @GetMapping(value = "user/query")
    public Result getUserList(int pageIndex, int pageSize) {
        if (0 == pageSize) {
            pageSize = this.pageSize;
        }
        if (0 == pageIndex) {
            pageIndex = this.pageIndex;
        }
        int currentPageIndex = (pageIndex-1)*pageSize;
        List<UserBean> list = enterService.getUserList(currentPageIndex, pageSize);

        if (list != null) {
            return Result.success(list);
        } else  {
            return Result.failure(ResultCode.FAILURE);
        }
    }

    @RequestMapping(value = "user/getUserInfo")
    @ResponseBody
    public Result getUserInfo(int id) {

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

        int code = enterService.add(userBean);

        if (code > 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.FAILURE);
        }
    }

    @RequestMapping(value = "user/delete")
    @ResponseBody
    public Result delete(int id) {
        int code = enterService.delete(id);
        if (code > 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.FAILURE);
        }
    }

    @RequestMapping(value = "user/update")
    @ResponseBody
    public Result delete(int id, UserBean userBean) {

        int code = enterService.update(id, userBean);

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

    @RequestMapping(value = "home/getHomeData")
    @ResponseBody
    public Result getHomeData() {

        List<Banner> banners = enterService.getBannerList();
        List<ClassBean> classBeans = enterService.getClassList();
        List<LiveBean> liveBeans = enterService.getLiveList();

        HashMap<String, Object> map = new HashMap<>();
        map.put("banners", banners);
        map.put("classes", classBeans);
        map.put("lives", liveBeans);

        if (banners != null) {
            return Result.success(map);
        } else  {
            return Result.failure(ResultCode.FAILURE);
        }
    }

}
