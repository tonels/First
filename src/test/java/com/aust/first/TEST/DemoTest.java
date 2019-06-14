package com.aust.first.TEST;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoTest {
    public static void main(String[] args) {
        String a = null;
        Matcher matcher = Pattern.compile("\\d{1,20}").matcher(a);
        System.out.println("为true吗  " + matcher.matches());

        String sa =null;



    }
}
