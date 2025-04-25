package com.example.back.mapper;

import org.apache.ibatis.annotations.*;

import com.example.back.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into `user` (username, password, name, phone, email, address, avatar) " +
            "values (#{username}, #{password}, #{name}, #{phone}, #{email}, #{address}, #{avatar})")
    void insert(User user);


    @Update("update `user` set username=#{username}, password=#{password}, name=#{name}, phone=#{phone}," +
            " email=#{email}, address=#{address}, avatar=#{avatar} where id=#{id}")
    void updateUser(User user);


    @Delete("delete from `user` where id = #{id}")
    void deleteUser(Integer id);

    @Select("select * from `user` order by id desc")
    List<User> selectAll();

    @Select("select * from `user` where id = #{id}")
    User selectById(Integer id);

    @Select("select * from `user` where username = #{username} and name = #{name} order by id desc")
    List<User> selectByMore(@Param("username") String username, @Param("name") String name);

    @Select("select * from `user` where username like concat('%', #{username}, '%') and " +
            "name like concat('%', #{name}, '%') order by id desc")
    List<User> selectByMo(@Param("username") String username, @Param("name") String name);
}
