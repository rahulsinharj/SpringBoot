package com.securitydemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitydemo.model.User;
import com.securitydemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers()
	{
		return this.userService.getAllUsers();
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{username}")
	public User getSingleUser(@PathVariable("username") String username)
	{
		return this.userService.getSigleUser(username);
	}

	@PostMapping("/")
	public List<User> addUser(@RequestBody User user)
	{
		return this.userService.addUser(user); 
	}
	
	
	
}
