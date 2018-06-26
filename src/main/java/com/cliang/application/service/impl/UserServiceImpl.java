package com.cliang.application.service.impl;

import com.cliang.application.dao.UserMapper;
import com.cliang.application.entity.User;
import com.cliang.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;


    @Override
    public int insertAllUsers(List<User> userList) {
        return userMapper.insertAll(userList);
    }
}
