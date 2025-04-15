package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;

    /*public static void main(String[] args) {
        User user = User.builder().name("heool").build();
        System.out.println(user.getName());
    }*/
}
