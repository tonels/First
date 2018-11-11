package com.aust.first.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", cid=" + cid + ", cname=" + cname + ", credit=" + credit + ", period=" + period
				+ "]";
	}
	
	
}
