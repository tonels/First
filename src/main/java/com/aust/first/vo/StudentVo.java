package com.aust.first.vo;

import lombok.Data;

@Data
public class StudentVo {

	private String sname;
	
	private Integer grade;

	public StudentVo(String sname, Integer grade) {
		super();
		this.sname = sname;
		this.grade = grade;
	}
	
	
}
