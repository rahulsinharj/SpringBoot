package com.securitydemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.securitydemo.model.User;
import com.securitydemo.repo.UserRepo;

@Service
public class UserDbService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void createUser() {
		
		User user1 = new User();
		user1.setEmail("ram@gmail.com");
		user1.setUsername("ram");
		user1.setPassword(bCryptPasswordEncoder.encode("ram1"));
		user1.setRole("ROLE_NORMAL");
		userRepo.save(user1);
		
		User user2 = new User();
		user2.setEmail("deepa@gmail.com");
		user2.setUsername("deepa");
		user2.setPassword(bCryptPasswordEncoder.encode("deepa1"));
		user2.setRole("ROLE_ADMIN");
		userRepo.save(user2);	
	}
	
	public List<User> getAllUsers()
	{
		return (List<User>)userRepo.findAll();
	}
}
