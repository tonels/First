package com.aust.first.util;

import com.aust.first.config.*;;


public class ResultBeanUtil {
	
	private String code;
	private String msg;
	private Object result;
	private boolean status;
	/**
     * 总的页数
     */
    private Integer total;
    /**
     * 总记录数
     */
    private Long totalCount;
	
	private ResultBeanUtil(String code, String msg, Object result,
			boolean status) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
		this.status = status;
	}
	
	public ResultBeanUtil(String code, String msg, Object result,
			boolean status, Integer total, Long totalCount) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
		this.status = status;
		this.total = total;
		this.totalCount = totalCount;
	}

	public static ResultBeanUtil ok() {
		return new ResultBeanUtil(CodeEnum.OK.getCode(), Constants.SUCCESS, null, true);
	}
	public static ResultBeanUtil ok(Object data){
		return new ResultBeanUtil(CodeEnum.OK.getCode(), Constants.SUCCESS, data, true);
	}
	
	public static ResultBeanUtil ok(Object data, Integer total, Long totalCount){
		return new ResultBeanUtil(CodeEnum.OK.getCode(), Constants.SUCCESS, data, true, total, totalCount);
	}
	
	public static ResultBeanUtil error(CodeEnum codeEnum, String msg){
		return new ResultBeanUtil(codeEnum.getCode(), msg, null, false);
	}
	
	public static ResultBeanUtil error(CodeEnum codeEnum){
		return new ResultBeanUtil(codeEnum.getCode(), codeEnum.getMsg(), null, false);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	
}
