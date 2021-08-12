package com.boot.rest.util;

import com.boot.rest.dto.UserDto;

public class Response<T> {

	private Integer status;
	private T data;

	public Response() {
	}

	public Response(Integer status, T data) {
		this.status = status;
		this.data = data;

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

}
