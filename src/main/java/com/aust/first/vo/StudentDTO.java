package com.aust.first.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long sid;
	private String sname;
	private Integer totalgrade;

}
