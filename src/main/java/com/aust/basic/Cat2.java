package com.aust.basic;

import lombok.Data;

@Data
public class Cat2 {

    private String name;
    private Integer age;
    private String color1;

    public Cat2(String name, Integer age,String color1) {
        this.name = name;
        this.age = age;
        this.color1 = color1;
    }
}
