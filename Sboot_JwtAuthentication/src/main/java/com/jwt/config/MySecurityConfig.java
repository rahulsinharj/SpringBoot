package com.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.service.CustomUserDetailsService;

@Configuration						// @Configuration - So that we can declare beans here
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception 
	{
		return super.authenticationManager();
	}
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override	// Kaun se URL ko secured rakhna hai, hamaraa filter kya hoga, and also disabling CSRF
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.csrf().disable()
			.cors().disable()
			.authorizeRequests()					// Requests ko authtorize karni hai
			.antMatchers("/token").permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);		// Session Management Policy "Stateless" rakhni hai. 
			
	}

	@Override	// Kaun sa Authentication use karna hai - InMemory/ or Dao auth
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(customUserDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
