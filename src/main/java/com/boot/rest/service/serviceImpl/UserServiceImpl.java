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

	@Override
	public UserDto addUser(UserDto userDto) {
		Optional<User> userModel = repo.findByEmail(userDto.getEmail());
		if (userModel.isPresent())
			throw new UnprocessableEntity("Email already Exist");
		User model = modelMapper.map(userDto, User.class);
		repo.save(model);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = repo.findAll();
		List<UserDto> userDto = users.stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		return userDto;

	}

	@Override
	public String getUser(String email) {
		Optional<User> user = repo.findByEmail(email);
		UserDto userDto = null;
		if (!user.isPresent())
			throw new DataNotFoundException("Data Not found");

		userDto = modelMapper.map(user.get(), UserDto.class);
		return user.toString();
	}

	@Override
	public String deleteUser(String email) {
		Optional<User> user = repo.findByEmail(email);
		if (!user.isPresent())
			throw new DataNotFoundException("Data Not found");
		else
			return email;
	}
}
