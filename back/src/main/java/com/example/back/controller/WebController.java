package com.example.back.controller;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.common.Result;
import com.example.back.entity.User;
import com.example.back.service.UserService;
/* 提供接口返回数据 */
@RestController
@RequestMapping("/web")
public class WebController {
    @Autowired
    UserService userService;
    
    /* 提供接口返回数据 */
    @GetMapping("/hello")
    public Result hello(String name) {
        return Result.success(name);
    }


    @PostMapping("/post")
    public Result post(@RequestBody Obj obj) { //发送json数据
        System.out.println(obj.getName() == null ? "null" : obj.getName().isEmpty());
        return Result.success(obj);
    }

    //更新
    @PutMapping("/update")
    public String putMethodName(@RequestBody User obj) {
        userService.updateUser(obj);
        return Result.success(obj).toString();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {

        return Result.success(id);
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(ids);
    }
}
