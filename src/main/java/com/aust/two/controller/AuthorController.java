package com.aust.two.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aust.first.util.ResultBean;
import com.aust.two.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/slc1")
    public ResultBean slc1() {
        return ResultBean.ok(authorService.findAll());
    }


    @GetMapping("/slc2")
    public ResultBean slc2() {
        return ResultBean.ok(authorService.findAll());
    }

    @GetMapping("/slc3")
    public ResultBean slc3() {
        return ResultBean.ok(authorService.findAll());
    }

}
