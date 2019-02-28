package com.aust.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aust.first.entity.Stu2;
import com.aust.first.service.Stu2Service;
import com.aust.first.util.PageBean;
import com.aust.first.util.ResultBean;

@RestController
@RequestMapping("/stu2")
public class Stu2Controller {

	@Autowired
	private Stu2Service stu2Service;

	// 添加一个
	@PostMapping("/add")
	public ResultBean addOne(@RequestBody Stu2 stu2) {
		return ResultBean.ok(stu2Service.save(stu2));
	}

	// 批量添加5个,这样写不行，是同一个学生重复添加了，就会变成更新了
	@PostMapping("/batchAdd_errorUpdate")
	public ResultBean add_error(@RequestBody Stu2 stu2) {
		for (int i = 0; i <= 5; i++) {
			stu2Service.save(stu2);
		}
		return ResultBean.ok();
	}

	// 批量添加20个,需要20个学生的信息，在service处理
	@PostMapping("/batchAdd")
	public ResultBean addbatch() {
		stu2Service.addbatch();
		return ResultBean.ok();
	}

	// 查询，findByid
	@GetMapping("/findById")
	public ResultBean findById(Long id) {
		return ResultBean.ok(stu2Service.findById(id));
	}

	// 查询，getOne,返回数据为 SyntaxError: JSON.parse: unexpected character at line 1
	// column 1 of the JSON data
	@GetMapping("/getOne")
	public ResultBean getOne(Long id) {
		return ResultBean.ok(stu2Service.getOne(id));
	}
	
	@GetMapping("/getOne.name")
	public ResultBean getOnename(Long id) {
		return ResultBean.ok(stu2Service.getOne(id).getName());
	}

	// 查询，findOneById
	@GetMapping("/findOneById")
	public ResultBean findOneById(Long id) {
		return ResultBean.ok(stu2Service.findOneById(id));
	}

	//与
	
	// 无条件查询全部，getAll,返回list
	@GetMapping("/getAll")
	public ResultBean getAll() {
		return ResultBean.ok(stu2Service.getAll());
	}

	// 无条件查询全部，getAll,返回Page,排序规则
	@GetMapping("/getAllByPage")
	public ResultBean getAllByPage() {
		return ResultBean.ok(stu2Service.getAllByPage());
	}

	// 无条件查询全部，getAll,返回list,排序
	@GetMapping("/getAllByListSort")
	public ResultBean getAllByListSort() {
		return ResultBean.ok(stu2Service.getAllByListSort());
	}

	// 有条件查询全部，getAll,返回list
	@GetMapping("/getAllfindByPage")
	public PageBean<Stu2> findByPage(Stu2 stu2, int page, int rows, String sord, String sidx) {
		Page<Stu2> pageable = stu2Service.findByPage(stu2, page, rows, sord, sidx);
		return PageBean.ok(pageable.getTotalPages(), pageable.getTotalElements(), pageable.getContent());
	}

	// getbyName,会有重名的，返回list
	@GetMapping("/getbyName")
	public ResultBean getbyName(String name) {
		return ResultBean.ok(stu2Service.findByName(name));
	}

}
