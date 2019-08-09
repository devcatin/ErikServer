package com.erik.erikdemo.dao;

import com.erik.erikdemo.bean.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BannerDao {

    @Select("SELECT * FROM banner")
    List<Banner> getBannerList();

}
