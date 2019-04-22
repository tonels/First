package com.aust.first.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.aust.first.vo.StudentDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@SqlResultSetMappings({
	@SqlResultSetMapping(
			name="studentmapping",
			classes = @ConstructorResult(
                    targetClass = StudentDTO.class,
                    columns = {
                        @ColumnResult(name = "sid", type = Long.class),
                        @ColumnResult(name = "sname"),
                        @ColumnResult(name = "totalgrade",type= Integer.class)})),
})
@Entity
@Table(name="student")
@SqlResultSetMapping( //lianbiao3_2没调出来
		    		name="CustomerVoResult",
		    		classes = {
		    			@ConstructorResult(
		    				targetClass=com.aust.first.vo.StudentVo2.class,
		    				columns={
		    					@ColumnResult(name="sname"),
		    					@ColumnResult(name="grade",type=Double.class),
		    			    }
		    		    )
		    		})
public class Student implements Serializable {
	/**
	 * 学生表
	 */
	private static final long serialVersionUID = 4046896220464492217L;

	/*主键ID*/
	private Long id;
	
	/*姓名*/
	private String sname;
	
	/*
	 * 学号
	 * 从1000-2000
	 * */
	private long sid;
	
	/*性别*/
	private String sex;
	
	/*年龄*/
	private int age;

	/*生日*/
	private transient LocalDateTime birthday; 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="sname",length=20,nullable=false)
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name="sex",length=20)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name="age",length=20,nullable=false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Column(name="sid",length=20,nullable=false)
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	@Column(name="birthday")
	public LocalDateTime getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", sid=" + sid + ", sex=" + sex + ", age=" + age + "]";
	}



	
	
	
	
}
