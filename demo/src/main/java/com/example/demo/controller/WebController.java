package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* 提供接口返回数据 */
@RestController
public class WebController {
    /* 提供接口返回数据 */
    @RequestMapping()
    public String hello() {
        return "Hello, World!";
    }
}
