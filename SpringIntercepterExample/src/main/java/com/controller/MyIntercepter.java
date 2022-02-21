package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyIntercepter implements HandlerInterceptor {

	private final Logger LOG = LoggerFactory.getLogger(MyIntercepter.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
		System.out.println("this is prehandler..");
		LOG.info("In Pre-HANDLER method of MyIntercepter class");
		
		String name = request.getParameter("user");
		if (name.startsWith("d")) {
			response.setContentType("text/html");
			response.getWriter().println("<h1>Invalid name ...Name should not starts with d</h1>");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception 
	{
		System.out.println("this is post handler");
		LOG.info("In Post-HANDLER method of MyIntercepter class");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception 
	{
		System.out.println("this is after completion method..");
		LOG.info("In AfterCompletion-HANDLER method of MyIntercepter class");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	 
	
}
