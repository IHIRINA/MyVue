package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.Result;
import com.example.demo.service.UserService; // Added import for UserService
import com.example.demo.entity.User; // Ensure this is the correct package for the User class



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /*新增用户信息 */
    @PostMapping("/add")
    public Result add(@RequestBody User user) { // Ensure User is the correct class for user entity
        userService.insertUser(user);
        return Result.success("success");
    }
}
