package com.aust.first.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String password;


}
