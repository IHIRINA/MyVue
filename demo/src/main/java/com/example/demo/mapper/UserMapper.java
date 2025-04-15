package com.example.demo.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import com.example.demo.entity.User; // Ensure this is the correct package for the User class

@Mapper
public interface UserMapper {

    @Insert("insrt into `user` (username , paswword , name , phone , email , address , avatar)" +
            "values (#{username}, #{password}, #{name}, #{phone}, #{email}, #{address}, #{avatar})")
    void insertUser(User user);
}

