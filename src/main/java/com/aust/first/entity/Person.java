package com.aust.first.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;


/*序列化到Redis中*/
@RedisHash("people")
@Data
@Accessors(chain = true) // 这里可以链式 拼接对象属性
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;

	private String firstname;

	private String lastname;

	private String age;

	private String bobbies;

}
