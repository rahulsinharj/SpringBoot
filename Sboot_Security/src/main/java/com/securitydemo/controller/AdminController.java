package com.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/adwork")
	public String adminStuffs()
	{
		System.out.println("Doing some Admin Stuffs !");
		return "Doing some Admin Stuffs";
	}
	
}
