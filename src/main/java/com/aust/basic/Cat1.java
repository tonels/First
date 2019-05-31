package com.aust.basic;

import lombok.Data;

@Data
public class Cat1 {
    private String name;
    private Integer age;
    private String color;

    public Cat1(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
