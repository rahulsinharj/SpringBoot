package com.actuatorDemo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/getdata")
	public Map<String, String> getdata()
	{
		return Map.of("Name","Rahul");
	}
	
	
}
