package com.aust.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aust.first.entity.Score;
import com.aust.first.repository.ScoreRepository;
import com.aust.first.util.ResultBeanUtil;

	@RestController
	@RequestMapping("/score")
	public class ScoreController {
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@GetMapping("/all")
	ResultBeanUtil sumall(){
		Pageable pageable = PageRequest.of(0, 20,Direction.ASC,"id");
		Page<Score> page = scoreRepository.findAll(pageable);
		return ResultBeanUtil.ok(page.getContent(),page.getTotalPages(),page.getTotalElements());
	} 
}
