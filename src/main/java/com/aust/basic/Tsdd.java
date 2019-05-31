package com.aust.basic;

import com.aust.first.util.CopyUtils;

public class Tsdd {

    public static void main(String[] args) {
        Cat1 cat1 = new Cat1("kitty", null, "red");
        Cat2 cat2 = new Cat2("heimao", 6,"black");
        CopyUtils.copyProperties(cat1,cat2); System.out.println(cat2.toString());  // Cat2(name=kitty, age=6, color1=black)
//        BeanUtils.copyProperties(cat1,cat2);System.out.println(cat2); // Cat2(name=kitty, age=null, color1=black)


    }
}
