package com.example.back.common;

//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//它们会自动生成无参构造方法和全参构造方法。

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {
    public static final String CODE_SUCCESS = "200";
    public static final String CODE_AUTH_ERROR = "401";

    public static final String CODE_ERROR = "500";

    /*
     * * 请求的返回编码 * 200: 成功 * 401: 未授权 * 500: 服务器错误
     */
    private String code;
    /*
     * msg表示错误的详细信息
     */
    private String msg;
    /*
     * * data表示请求返回的数据 *
     */
    private Object data;


    public static Result success(Object data) {
        return Result.builder().code(CODE_SUCCESS).msg("success").data(data).build();
    }

    public static Result error(String s) {
        return Result.builder().code(CODE_ERROR).msg("sys_error").build();
    }

}

