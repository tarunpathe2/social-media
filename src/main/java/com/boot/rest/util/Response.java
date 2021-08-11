package com.boot.rest.util;

import com.boot.rest.dto.UserDto;

public class Response<T> {
	
	private Integer status;
	private T data;
	private String message;
	private Object error;

	public Response(int i, UserDto userDto, String string, Object object) {
	}

	public Response(Integer status, T data, String message, Object error) {
		this.status = status;
		this.data = data;
		this.message = message;
		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

}
