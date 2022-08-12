package com.spring.mvc.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.spring.mvc.dto.UserDto;
import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
		UserDto resultUser = userService.createUser(user);
		return ResponseEntity.ok(resultUser);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getUsers(){  
		List<UserDto> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
		UserDto user = userService.getUser(id);
		return ResponseEntity.ok(user);		
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto user){
		UserDto resultUser = userService.updateUser(id,user);
		return ResponseEntity.ok(resultUser);
	}
	
	@GetMapping("/pagination")
	public ResponseEntity<Page<User>> pagination(@RequestParam int currentPage,@RequestParam int pageSize){
		return ResponseEntity.ok(userService.pagination(currentPage, pageSize));
	}
	
	
	
	@DeleteMapping("/remove/{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") Long id){
		Boolean status = userService.deleteUser(id);
		return ResponseEntity.ok(status);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
