package com.aust.two.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aust.first.util.ResultBean;
import com.aust.two.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/slc1")
	public ResultBean slc1() {
		return ResultBean.ok(bookService.findAll());
	}
	
	//自定义返回pojo,会显示  no entity,没有对应的entity
	@GetMapping("/slc2")
	public ResultBean slc2() {
		return ResultBean.ok(bookService.findBookValue());
	}
	
	//自定义mappping映射
	@GetMapping("/slc3")
	public ResultBean slc3() {
		return ResultBean.ok(bookService.findBookValue2());
	}
}
