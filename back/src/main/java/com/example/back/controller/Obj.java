package com.example.back.controller;

import lombok.Setter;

public class Obj {
    @Setter
    private String name;
    private String id;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
