package com.erik.erikdemo.dao;


import com.erik.erikdemo.bean.Banner;
import com.erik.erikdemo.bean.ClassBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HomeDao {

    @Select("SELECT * FROM sys_banner")
    List<Banner> getBannerList();

    @Select("SELECT * FROM sys_class")
    List<ClassBean> getClassList();

}
