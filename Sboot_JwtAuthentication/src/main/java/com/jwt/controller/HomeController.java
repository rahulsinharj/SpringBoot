package com.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/welcome")
	public String welcome()
	{
		String text = "This is a private page. ";
		text += "Welcome to this page, only allowed to Authenticated users.";
		
		return text;
 	}
	
	
	
}
