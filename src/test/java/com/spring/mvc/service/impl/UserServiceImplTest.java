package com.spring.mvc.service.impl;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.mvc.dto.UserDto;
import com.spring.mvc.entity.User;
import com.spring.mvc.repository.UserRepository;

@SpringBootTest
public class UserServiceImplTest {

	private UserServiceImpl userServiceImpl;
	private UserRepository userRepository;
	private ModelMapper modelMapper;
	
	@BeforeEach
	public void setUp() throws Exception{
		System.err.println("wedıowoı");
		modelMapper = new ModelMapper();
		userRepository = Mockito.mock(UserRepository.class);
		modelMapper = Mockito.mock(ModelMapper.class);
		userServiceImpl  = new UserServiceImpl(userRepository, modelMapper);		
	}	
	
	@Test
	public void whenCreateUserCalledWithValidRequest_ThenItShouldReturnValidUserDTO() {		
		UserDto userDto = new UserDto();
		userDto.setFirstName("Hakan");
		userDto.setLastName("Karaagac");
		

		User user = modelMapper.map(userDto,User.class);	
		user.setCreateDate(new Date());
		user.setCreatedBy("Admin");
		
		Mockito.when(userServiceImpl.createUser(userDto)).thenReturn(userDto);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		
		UserDto result = userServiceImpl.createUser(userDto);
		
		Assert.assertEquals(result, userDto);
		
		Mockito.verify(userServiceImpl.createUser(userDto));
		Mockito.verify(userRepository).save(user);
		
	}
	
	/*
	@Test
	public void whenCreateUserCalledWithrrValidRequest_ThenItShouldReturnValidUserDTO() {
		String message = "umuttt";
		UserDto userDto = new UserDto(message);
		userDto.setFirstName("ddqdq");
		userDto.setLastName("Karqdqwaagac");
		Mockito.when(userServiceImpl.createUser(userDto)).thenReturn(userDto);
	}*/
	
	
	
}
