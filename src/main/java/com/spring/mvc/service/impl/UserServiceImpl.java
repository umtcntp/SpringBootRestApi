package com.spring.mvc.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.mvc.dto.UserDto;
import com.spring.mvc.entity.User;
import com.spring.mvc.repository.UserRepository;
import com.spring.mvc.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
		this.modelMapper = new ModelMapper();
	}
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = modelMapper.map(userDto,User.class);	
		user.setCreateDate(new Date());
		user.setCreatedBy("Admin");
		return modelMapper.map(userRepository.save(user), UserDto.class);
	}


	@Override
	public List<UserDto> getUsers() {	
		List<User> users = userRepository.findAll();
		List<UserDto> dtos = users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public UserDto getUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			
			return modelMapper.map(user.get(), UserDto.class);
		}
		return null;
	}

	@Override
	public UserDto updateUser(Long id, UserDto user) {
		Optional<User> resultUser = userRepository.findById(id);
		if(resultUser.isPresent()) {
			resultUser.get().setFirstName(user.getFirstName());
			resultUser.get().setLastName(user.getLastName());
			resultUser.get().setUpdateAt(new Date());
			resultUser.get().setUpdateBy("Admin");
			return modelMapper.map(userRepository.save(resultUser.get()), UserDto.class);

		}
		return null;
	}

	@Override
	public Boolean deleteUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Page<User> pagination(int currentPage, int pageSize) {
		Pageable pageable =  PageRequest.of(currentPage, pageSize);
		return userRepository.findAll(pageable);
	}



	

	
	

}
