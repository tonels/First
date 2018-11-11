package com.aust.first.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score implements Serializable {

	/**
	 * 成绩表
	 */
	private static final long serialVersionUID = 5872214962771011043L;

	/*主键ID*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/*学生学号*/
	@Column(name="sid")
	private Long sid;
	
	/*课程号*/
	@Column(name="cid")
	private Long cid;
	
	/*成绩*/
	@Column(name="grade")
	private Integer grade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", sid=" + sid + ", cid=" + cid + ", grade=" + grade + "]";
	}
	
	
}
