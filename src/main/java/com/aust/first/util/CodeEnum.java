package com.aust.first.util;


public enum CodeEnum{
	/*
	0000  成功 
	1000  请求参数错误
	2002  数据库入库异常
	2003  删除失败
	
	2101  请求参数为空
	
	9999  其它，自定义错误
	*/
	OK("0000", "成功"),
	PARAMS_ERROR("1000","请求参数错误"),
	DATABASE_ERROR("2002","数据库入库异常"),
	DELETE_ERROR("2003", "删除失败"),

	PARAMS_EMPTY("2101","请求参数为空"),
	CUSTON_ERROR("9999", " 其它，自定义错误");
	
	private String code;
	private String msg;
	
	private CodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
