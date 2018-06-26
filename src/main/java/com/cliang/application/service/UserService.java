package com.cliang.application.service;

import com.cliang.application.dao.UserMapper;
import com.cliang.application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    int insertAllUsers(List<User> userList);
}
