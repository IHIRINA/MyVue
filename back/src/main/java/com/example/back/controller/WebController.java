package com.example.back.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.common.Result;

/* 提供接口返回数据 */
@RestController
@RequestMapping("/web")
public class WebController {
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
    @PutMapping("/put")
    public String putMethodName(@RequestBody Obj obj) {
        return Result.success(obj).toString();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(id);
    }
}
