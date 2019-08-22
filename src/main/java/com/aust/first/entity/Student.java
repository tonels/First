package com.aust.first.entity;

import com.aust.first.vo.StudentDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
@Data
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
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/*姓名*/
	@Column(name="sname",length=20,nullable=false)
	private String sname;
	
	/*
	 * 学号
	 * 从1000-2000
	 * */
	@Column(name="sid",length=20,nullable=false)
	private long sid;
	
	/*性别*/
	@Column(name="sex",length=20)
	private String sex;
	
	/*年龄*/
	@Column(name="age",length=20,nullable=false)
	private int age;

	/*生日*/
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	@Column(name="birthday")
	private /*transient*/ LocalDateTime birthday;

}
