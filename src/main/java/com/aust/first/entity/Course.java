package com.aust.first.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="course")
public class Course implements Serializable{

	/**
	 * 课程表
	 */
	private static final long serialVersionUID = 7399202243199989761L;
	/*
	 * 主键Id
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	/*
	 * 课程号cid，从1-10
	 * */
	@Column(name="cid",length=10,unique=true)
	private Long cid;
	/*
	 * 课程名cname
	 * */
	@Column(name="cname",length=20)
	private String cname;
	/*
	 * 学分
	 * */
	@Column(name="credit")
	private Integer credit;
	/*
	 * 总学时
	 * */
	@Column(name="period")
	private Integer period;

}
