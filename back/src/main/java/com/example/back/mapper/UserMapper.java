package com.example.back.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.back.entity.User;

@Mapper
public interface UserMapper{

    @Insert("insert into `user` (username, password, name, phone, email, address, avatar) " +
            "values (#{username}, #{password}, #{name}, #{phone}, #{email}, #{address}, #{avatar})")
    void insert(User user);
    
}
