package com.example.back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.common.Result;
import com.example.back.entity.User;
import com.example.back.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /*新增用户信息 */
    @PostMapping("/add")
    public Result add(@RequestBody User user) { // Ensure User is the correct class for user entity
        try {
            userService.insertUser(user);
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                return Result.error( "Database error: ");
            } else {
                return Result.error( "Unknown error: " );    
            }
        }
        return Result.success("success");
    }
}
