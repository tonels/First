package com.aust.first.controller;

import com.aust.first.service.CombineService;
import com.aust.first.util.ResultBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/combine")
public class CombineController {

    @Resource
    private CombineService combineService;

    @GetMapping("/com1Vo")
    public ResultBean get(){
        return ResultBean.ok(combineService.getCom1Vo());
    }
}
