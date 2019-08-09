package com.erik.erikdemo.dao;

import com.erik.erikdemo.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {

    @Select("SELECT * FROM user")
    List<UserBean> getUserList();

    @Select("SELECT * FROM user WHERE userid = #{id}")
    UserBean getUserInfo(Integer id);

}
