package com.boot.rest.service;

import java.util.List;

import com.boot.rest.dto.UserDto;

public interface UserService {
	
	public String addUser(UserDto userDto);
	public List<UserDto> getAllUsers();
	public UserDto getUser(String email);
	public void deleteUser(long id);

}
