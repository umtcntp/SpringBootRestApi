package com.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import com.spring.mvc.entity.User;





public interface UserRepository extends JpaRepository<User,Long>{
	
}
