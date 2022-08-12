package com.spring.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.spring.mvc.dto.UserDto;
import com.spring.mvc.entity.User;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	List<UserDto> getUsers();
	UserDto getUser(Long id);
	UserDto updateUser(Long id,UserDto user);
	Boolean deleteUser(Long id);
	Page<User> pagination(int currentPage, int pageSize);
	

}
