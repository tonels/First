package com.aust.first.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name="ls_stu2")
public class Stu2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
	private Long id; 
	 /**
     *学号
     */
	@Column(name="sid_")
	private Long sid; 
	 /**
     *姓名
     */
	@Column(name="name_")
	private String name; 
	 /**
     * 年龄
     */
	@Column(name="age_")
	private Integer age; 
	 /**
     * 联系方式
     */
	@Column(name="phone_")
	private String phone;
	 /**
     * 爱好
     */
	@Column(name="hobbies_")
	private String hobbies; 
	 /**
     * 个人签名
     */
	@Column(name="summary_")
	private String summary; 
	 /**
     * 创建人
     */
	@Column(name = "created_by")
	private String createdBy; 
	 /**
     * 入校时间
     */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "admission_time")
	private LocalDateTime admissionTime;

}
