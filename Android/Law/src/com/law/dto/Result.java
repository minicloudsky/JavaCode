package com.law.dto;

import java.util.List;

/**
 * 封装json对象
 * @author DELL
 *
 */
public class Result<T> {

	private boolean success;
	
	
	private List<T> data;
	
	private String error;
	
	public Result() {
		
	}
	
	public Result(boolean success,List<T> data) {
		this.success = success;
		this.data = data;
	}
	
	public Result(boolean success,String error) {
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", data=" + data + ", error=" + error + "]";
	}	
	
}
