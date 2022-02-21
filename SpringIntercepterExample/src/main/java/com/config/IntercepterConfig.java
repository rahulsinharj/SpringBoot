package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.controller.MyIntercepter;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

	@Autowired
	private MyIntercepter myIntercepter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) 
	{
		registry.addInterceptor(myIntercepter).addPathPatterns("/welcome");
//		registry.addInterceptor(myIntercepter).addPathPatterns("/home");		// Now we just need to add those Mapped URL, whom we want to include with this "MyIntercepter" 
	}																			// For using any other intercepter also, then we need to create an another MyIntercepter2 class => include @Configuration in it also , and implements WebMvcConfigurer 

	
	
	
}
