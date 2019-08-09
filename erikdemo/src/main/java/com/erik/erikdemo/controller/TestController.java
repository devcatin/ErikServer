package com.erik.erikdemo.controller;

import com.erik.erikdemo.base.BaseConfig;
import com.erik.erikdemo.bean.MsgBean;
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
    public MsgBean getUserList() {
        MsgBean msgBean = new MsgBean();
        try {
            List<UserBean> list = enterService.getUserList();
            msgBean.setCode(BaseConfig.SUCCESSCODE);
            msgBean.setMsg(BaseConfig.SUCCESSMSG);
            msgBean.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            msgBean.setCode(BaseConfig.ERRRORCODE);
            msgBean.setMsg(BaseConfig.ERRRORMSG);
            msgBean.setData(BaseConfig.ERRRORMSG);
        }
        return msgBean;
    }

    @RequestMapping(value = "user/getUserInfo")
    @ResponseBody
    public MsgBean getUserInfo(Integer id) {
        MsgBean msgBean = new MsgBean();
        try {
            UserBean userBean = enterService.getUserInfo(id);
            msgBean.setCode(BaseConfig.SUCCESSCODE);
            msgBean.setMsg(BaseConfig.SUCCESSMSG);
            msgBean.setData(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            msgBean.setCode(BaseConfig.ERRRORCODE);
            msgBean.setMsg(BaseConfig.ERRRORMSG);
            msgBean.setData(BaseConfig.ERRRORMSG);
        }
        return msgBean;
    }

}
