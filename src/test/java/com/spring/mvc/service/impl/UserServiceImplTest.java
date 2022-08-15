package com.spring.mvc.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import com.spring.mvc.repository.UserRepository;
import com.spring.mvc.service.impl.UserServiceImpl;

@SpringBootTest
public class UserServiceImplTest {

	private UserServiceImpl userServiceImpl;
	private UserRepository userRepository;
	private ModelMapper modelMapper;
	
	@Before
	public void setUp() throws Exception{
		userRepository = Mockito.mock(UserRepository.class);
		modelMapper = Mockito.mock(ModelMapper.class);
		userServiceImpl  = new UserServiceImpl(userRepository, modelMapper);
		
	}	
	
	@Test
	public void whenCreateUserCalledWithValidRequest_ThenItShouldReturnValidUserDTO() {
		System.err.println("wsgışewrjommgsvndfvdn");
	}
	
	
	
}
