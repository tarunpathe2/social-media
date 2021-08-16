package com.boot.rest.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.rest.dto.UserDto;
import com.boot.rest.exception.DataNotFoundException;
import com.boot.rest.exception.UnprocessableEntity;
import com.boot.rest.model.User;
import com.boot.rest.repository.UserRepository;
import com.boot.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	UserRepository repo;

	private void isExist(String email) {
		if (!repo.existsByEmail(email)) {
			throw new DataNotFoundException("User does not exist");
		}
	}
	
	@Override
	public String addUser(UserDto userDto) {
		if (repo.findByEmail(userDto.getEmail()).isPresent())
			throw new UnprocessableEntity("Email already Exist");
		User user = modelMapper.map(userDto, User.class);
		repo.save(user);
		return userDto.getEmail();
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = repo.findAll();
		List<UserDto> userDto = users.stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		return userDto;

	}

	@Override
	public UserDto getUser(String email) {
		Optional<User> user = repo.findByEmail(email);
		UserDto userDto = null;
		if (!user.isPresent())
			throw new DataNotFoundException("Data Not found");

		userDto = modelMapper.map(user.get(), UserDto.class);
		return userDto;
	}

	@Override
	public void deleteUser(long id) {
		
		repo.deleteById(id);
	
			
	}
}
