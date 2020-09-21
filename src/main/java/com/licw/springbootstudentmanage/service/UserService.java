package com.licw.springbootstudentmanage.service;

import com.licw.springbootstudentmanage.beans.User;
import com.licw.springbootstudentmanage.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserMapper userMapper;

    public User getById(String id){
        return userMapper.getById(id);
    }



}
