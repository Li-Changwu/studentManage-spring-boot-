package com.licw.springbootstudentmanage.mapper;

import com.licw.springbootstudentmanage.beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Select("select * from user where userName=#{userName}")
    User getById(@Param("userName") String userName);
}

