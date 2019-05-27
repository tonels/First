package com.aust.first.controller;

import com.aust.first.service.GitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GitController {

    @Resource
    private GitService gitService;

    @GetMapping("/")
    public String g1(){
        return gitService.g1();
    }

    @GetMapping("/")
    public String g2(){
        return gitService.g2();
    }

    @GetMapping("/")
    public String g33(){
        return gitService.g33();
    }


    @GetMapping("/")
    public String g3(){
        return gitService.g3();
    }
}
