package com.aust.first.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
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
	
}
