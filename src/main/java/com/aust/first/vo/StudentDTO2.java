package com.aust.first.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Object sid;
	private Object sname;
	private Object totalgrade;

}
