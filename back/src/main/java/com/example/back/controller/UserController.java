package com.example.back.controller;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import com.example.back.common.Result;
import com.example.back.entity.User;
import com.example.back.service.UserService;


@CrossOrigin
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

    /*更新用户信息 */
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.updateUser(user);
        return Result.success("success");
    }

    /*删除用户信息 */
    @DeleteMapping("/delete/{id}")
    public Result delete(@RequestBody Integer id) {
        userService.deleteUser(id);
        return Result.success("success");
    }

    /*批量删除 */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        userService.deleteBatch(ids);
        return Result.success("success");
    }

    @GetMapping("/selectAll")
    public Result selectAll() {
        List<User> userList = userService.selectAll();
        return Result.success(userList);
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        User user =  userService.selectById(id);
        return Result.success(user);
    }

    @GetMapping("/selectByMore")
    public Result selectByMore(@RequestParam String username, @RequestParam String name) {
        List<User> user = Collections.singletonList(userService.selectByMore(username, name));
        return Result.success(user);
    }

    @GetMapping("/selectByMo")
    public Result selectByMo(@RequestParam String username, @RequestParam String name) {
        List<User> user = Collections.singletonList(userService.selectByMo(username, name));
        return Result.success(user);
    }
/*
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam String username, @RequestParam String name) {
        Map<String , Object> map = Collections.singletonMap("username", username);
    }

 */
}
