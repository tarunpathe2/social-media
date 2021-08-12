package com.boot.rest.service;

import java.util.List;

import com.boot.rest.dto.UserDto;

public interface UserService {
	
	public UserDto addUser(UserDto userDto);
	public List<UserDto> getAllUsers();
	public String getUser(String email);
	public String deleteUser(String email);

}
