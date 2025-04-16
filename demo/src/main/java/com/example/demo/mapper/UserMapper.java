package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO `user` (username, password, name, phone, email, address, avatar) " +
            "VALUES (#{username}, #{password}, #{name}, #{phone}, #{email}, #{address}, #{avatar})")
    void insertUser(User user);
}