package com.jwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		if(username.equals("rahul"))
		{
			return new User("rahul", "rahul123", new ArrayList<>());
		}
		else 
		{
			throw new UsernameNotFoundException("User Not Found !");
		}
		
	}

	
}
