package com.aust.first.controller;

import com.aust.first.entity.Teacher;
import com.aust.first.repository.TeacherRepository;
import com.aust.first.util.DesSecurity;
import com.aust.first.util.ResultBeanUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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

		@GetMapping("/get_1")
		ResultBeanUtil get1(){
			Specification<Teacher> specification = new Specification<Teacher>() {
				@Override
				public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
					ArrayList<Predicate> predicates = Lists.newArrayList();
					return cb.and(predicates.toArray(new Predicate[predicates.size()]));
				}
			};
			List<Teacher> list = teacherRepository.findAll(specification);
			list.forEach((as)->System.out.println(as));
			return ResultBeanUtil.ok(list);
		}

		@DeleteMapping("/delete")
		ResultBeanUtil delete(String ids){
			String[] idarray = ids.split(",");
			for (String id : idarray){
				teacherRepository.deleteById(Integer.valueOf(id));
			}
			return ResultBeanUtil.ok();
		}
		
		

		
}
