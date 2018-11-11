package com.aust.first.entity;

import java.io.Serializable;

import javax.persistence.Id;
import org.springframework.data.redis.core.RedisHash;


/*序列化到Redis中*/
@RedisHash("people")
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String id;
	String firstname;
	String lastname;
	String age;
	String bobbies;
	
	
	public Person(String id, String firstname, String lastname, String age, String bobbies) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.bobbies = bobbies;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBobbies() {
		return bobbies;
	}
	public void setBobbies(String bobbies) {
		this.bobbies = bobbies;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", bobbies=" + bobbies + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
