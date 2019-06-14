package com.aust.first.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RedisUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Integer age;

	

}
