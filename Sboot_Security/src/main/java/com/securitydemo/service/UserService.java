package com.securitydemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.securitydemo.model.User;

@Service
public class UserService {

	List<User> list = new ArrayList<>();

	public UserService() 
	{
		list.add(new User("abc","abc","abc@gmail.com"));
		list.add(new User("xyz","xyz","xyz@gmail.com"));
	}
	
	// Get all users ::
	public List<User> getAllUsers(){
		return this.list;
	}
	
	// Get 1 user ::
	public User getSigleUser(String username){
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	// Add User and show all
	public List<User> addUser(User u) {
		this.list.add(u);
		return list;
	}
	
	
}
