package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User; // Ensure this is the correct package for the User class
import com.example.demo.mapper.UserMapper; // Ensure this is the correct package for the UserMapper interface


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
