package com.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.service.CustomUserDetailsService;
import com.jwt.util.JwtUtility;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException 
	{
		System.out.println("Inside Jwt-Authentication-FILTER");
		
		// Get Jwt
		// And it is starting with Bearer
		// Then Validate
		
		String authorizationHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		// Null And Format check ::
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) 
		{
			jwtToken = authorizationHeader.substring(7);
			
			try {
				username = this.jwtUtility.getUsernameFromToken(jwtToken);		// retrieve username from jwt token
				System.out.println("Token Username : "+username);
			} 
			catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
				e.printStackTrace();
			} 
			catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			LOGGER.warn("JWT Token does not begin with Bearer String");
			System.out.println("JWT Token does not begin with Bearer String");
		}
		
		// Once we get the token, validate it.
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);	// Validating the USERNAME by retrieving the USER DETAILS (either from Database)

			// If token is valid, configure Spring Security to manually set authentication.
			if (jwtUtility.validateToken(jwtToken, userDetails)) 
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

	            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

	            // After setting the Authentication in the context, we specify that the current user is authenticated. So it passes the Spring Security Configurations successfully.  
	            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
        }
		else {
			LOGGER.warn("Token is not validated..");
			System.out.println("Token is not validated..");
        }
		
		filterChain.doFilter(request, response);
	}

	
	
}
