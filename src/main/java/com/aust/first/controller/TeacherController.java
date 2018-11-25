package com.aust.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aust.first.entity.Teacher;
import com.aust.first.repository.TeacherRepository;
import com.aust.first.util.DesSecurity;
import com.aust.first.util.ResultBeanUtil;

	@RestController
	@RequestMapping("/teacher")
	public class TeacherController {

		@Autowired
		private TeacherRepository teacherRepository;

		@GetMapping("/add")
		ResultBeanUtil add(Teacher teacher){
			for (int i = 0; i < 3; i++) {
				String pass = teacher.getPassword();
		teacher.setPassword(DesSecurity.encryptBasedDes(pass));
			teacherRepository.saveAndFlush(teacher);
			}
		return ResultBeanUtil.ok();
		}
		
		@GetMapping("/get")
		ResultBeanUtil get(){
			List<Teacher> list = teacherRepository.findAll();
			list.forEach((as)->System.out.println(as));
			return ResultBeanUtil.ok(list);
		}
		
		

		
}
