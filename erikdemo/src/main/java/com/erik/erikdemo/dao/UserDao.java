package com.erik.erikdemo.dao;

import com.erik.erikdemo.bean.UserBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {

    @Select("SELECT * FROM sys_user LIMIT #{pageIndex},#{pageSize}")
    List<UserBean> getUserList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    UserBean getUserInfo(int id);

    @Insert("INSERT INTO sys_user(username,password,age,sex) VALUES(#{user.username},#{user.password},#{user.age},#{user.sex})")
    int add(@Param("user") UserBean userBean);

    @Delete("DELETE FROM sys_user WHERE id=#{id}")
    int delete(int id);

    @Update("UPDATE sys_user SET username=#{user.username},password=#{user.password},age=#{user.age},sex=#{user.sex} WHERE id=#{id}")
    int update(@Param("id") int id, @Param("user") UserBean userBean);

}
