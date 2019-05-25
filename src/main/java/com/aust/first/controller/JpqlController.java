package com.aust.first.controller;

import com.aust.first.service.JpqlService;
import com.aust.first.util.ResultBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jpql")
public class JpqlController {
    @Resource
    private JpqlService jpqlService;

//***********************************************************************基于JPA的 @Query 查询

    // ****************************************************基于JPQL查询

    //查询所有学生
    @GetMapping("/s1")
    public ResultBean s1(){
        return ResultBean.ok(jpqlService.s1());
    }

    @GetMapping("/s1_1")
    public ResultBean s1_1(){
        return ResultBean.ok(jpqlService.s1_1());
    }

    @GetMapping("/s1_2")
    public ResultBean s1_2(Integer age){
        return ResultBean.ok(jpqlService.s1_2(age));
    }

    @GetMapping("/s1_4")
    public ResultBean s1_4(String ages){
        return ResultBean.ok(jpqlService.s1_4(ages));
    }

    @GetMapping("/s1_4_1")
    public ResultBean s1_4_1(String ages){
        return ResultBean.ok(jpqlService.s1_4_1(ages));
    }

//    @GetMapping("/s1_5")                         // 调不通
//    public ResultBean s1_5(){
//        return ResultBean.ok(jpqlService.s1_5());
//    }

    @GetMapping("/s1_6")
    public ResultBean s1_6(){
        return ResultBean.ok(jpqlService.s1_6());
    }

    @GetMapping("/s1_61")
    public ResultBean s1_61(){
        return ResultBean.ok(jpqlService.s1_61());
    }

    @GetMapping("/s1_62")
    public ResultBean s1_62(){
        return ResultBean.ok(jpqlService.s1_62());
    }



    //所有学生姓名
    @GetMapping("/s2")
    public ResultBean s2(){
        return ResultBean.ok(jpqlService.s2());
    }

    // ****************************************************基于NativeSQL的本地查询

    //所有学生,nativeSQL
    @GetMapping("/s3")
    public ResultBean s3(){
        return ResultBean.ok(jpqlService.s3());
    }

    @GetMapping("/s3_1")
    public ResultBean s3_1(){
        return ResultBean.ok(jpqlService.s3_1());
    }

    @GetMapping("/s3_2")
    public ResultBean s3_2(){
        return ResultBean.ok(jpqlService.s3_2());
    }


// ********************************************************************************************基于 Specification 查询

    @GetMapping("/s4")
    public ResultBean s4(){
        return ResultBean.ok(jpqlService.s4());
    }

    @GetMapping("/s4_1")
    public ResultBean s4_1(String sex){
        return ResultBean.ok(jpqlService.s4_1(sex));
    }

    @GetMapping("/s4_2")
    public ResultBean s4_2(){
        return ResultBean.ok(jpqlService.s4_2());
    }

}
