package com.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)						// Iss line se @PreAuthorize("hasRole('ADMIN')") jo use kiye hai UserController class me wo annotation Enable ho jayega. 
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	
/* 	Basic Authentication me Logout nhi hota hai. , and login user check bhi basic http based hojata hai.
 * 		Also, without any AntMatcher -> SpringSecurtiy will provide authentication for all the URLs.	
 -------------------------------------------------------------------------------------------------------------------*/	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()		// Hame request ko authorize karna hai
//			.anyRequest()				// Jo koi bhi request ho , sabko
//			.authenticated()			// Jo bhi permission access karne hai wo pehle authenticated/check hongi
//			.and().httpBasic();			// And the Mechanism that we will use will be basic-http-mechanism.
//	}
	
	
/* 	[AntMatchers ::] Bydefault if we have to make any URL(eg- Homepage) as public. Then we can use AntMatchers, jisse ki URL-Pattern match karake then only User ko access milega uss particular URL ka.
 		
 	// better to use => .antMatchers("/user/**").hasRole("USER")    .antMatchers("/**").permitAll() 
 -------------------------------------------------------------------------------------------------------------------*/	
//	@Override																
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()		
//			.antMatchers("/admin/**").hasRole("ADMIN")			// bydefault role me "ROLE_" already append rehta hai.	
//			.antMatchers("/users/**").hasRole("NORMAL")			// If we comment this line, that means we are not mentioning here security for "/users" => that means "/users" ke liye koi ROLE_ based authentication nhi karna hai, bas normal username&password Authentication hoga.  
//			.antMatchers("/public/**").permitAll()		// Better to use .antMatchers("/**").permitAll()	// yaha permitAll() maane ki "/public/**" se start hone wale URL me koi Authentication mat lagao 	// {.antMatchers("/home","/login","/register").permitAll()	notRecommented to use URL separately, better to use classLevel Mapping URL } 		
//			.anyRequest()				
//			.authenticated()			
//			.and().httpBasic();			
//	}
	
	
/* 	"CSRF" : means Cross Site Request Forgery, 
	 It is an attack vector that tricks a web browser into executing an unwanted action in an application to which a user is logged in.		

* 	Jab bhi hum POST ya PUT method maarege to CSRF bydefault enabled ke wagah se hame POST/PUT karne ka allow nhi dega.
		Therefore we explicitely have to disable it, for using POST/PUT	. Because this POST/PUT api here will be called by non-browser client (i.e, any application) 

*	Also doing SpringBoot created "Inbuilt Form Based Authentication" , despite of "Basic-HTTP Based Authentication"
-------------------------------------------------------------------------------------------------------------------*/
	@Override																
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()								// Disabling the CSRF for using POST/PUT
			.authorizeRequests()		
			.antMatchers("/admin/**").hasRole("ADMIN")			// bydefault role me "ROLE_" already append rehta hai.	
			.antMatchers("/users/**").hasRole("NORMAL")			// If we comment this line, that means we are not mentioning here security for "/users" => that means "/users" ke liye koi ROLE_ based authentication nhi karna hai, bas normal username&password Authentication hoga.  
			.antMatchers("/public/**").permitAll()	 	// Better to use .antMatchers("/**").permitAll()	// yaha permitAll() maane ki "/public/**" se start hone wale URL me koi Authentication mat lagao 	// {.antMatchers("/home","/login","/register").permitAll()	notRecommented to use URL separately, better to use classLevel Mapping URL } 		
			.anyRequest()				
			.authenticated()			
//			.and().httpBasic();							// Basic-HTTP Based Authentication
			.and().formLogin();							// SpringBoot created "Inbuilt Form" Based Authentication
//			.and().formLogin().loginPage("/signin"); 		// Custom LOGIN/Signin page bhi banke uske authentication page ki tarah treat karwa sakte hai.
	}
	

/* 	If we don't want csrf().disable(), and we want to give access only to some particular token for POST/PUT , then client also have to set a cookie named "X-XSRF-TOKEN" in Header section of PostMan , whatever the cookie has been coming from server.
-------------------------------------------------------------------------------------------------------------------*/
//	@Override																
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//			.and()
//			.authorizeRequests()		
//			.antMatchers("/admin/**").hasRole("ADMIN")			// bydefault role me "ROLE_" already append rehta hai.	
//			.antMatchers("/users/**").hasRole("NORMAL")			// If we comment this line, that means we are not mentioning here security for "/users" => that means "/users" ke liye koi ROLE_ based authentication nhi karna hai, bas normal username&password Authentication hoga.  
//			.antMatchers("/public/**").permitAll()				// yaha permitAll() maane ki "/public/**" se start hone wale URL me koi Authentication mat lagao 	// {.antMatchers("/home","/login","/register").permitAll()	notRecommented to use URL separately, better to use classLevel Mapping URL } 		
//			.anyRequest()				
//			.authenticated()			
//			.and().httpBasic();			
//	}	
	
	
	
// In below method, password ka mechanism bhi hamko zaroor se batana hota hai=> whether it is of type "BCryptPasswordEncoder, or NoOpPasswordEncoder"   	
	
/* 	[ inMemoryAuthentication i.e,  Making our own USER and Password, keeping them only temporarily i.e, in MainMemory storage ::] 
 *  	& using "NoOpPasswordEncoder" (i.e, keeping passwords as plain text, )	
 -------------------------------------------------------------------------------------------------------------------*/	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication().withUser("rahul").password("rahul1").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("vikas").password("vikas1").roles("NORMAL");			
//	}

/* 	For Creating passwords as "plain text" as it is given my user . 
 -------------------------------------------------------------------------------------------------------------------*/
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	
	
/* 	[ inMemoryAuthentication i.e,  Making our own USER and Password, keeping them only temporarily i.e, in MainMemory storage ::] 
 *  	& Encrypting our Password by using "BCryptPasswordEncoder" (i.e, Whatever password given by user -> will be getting Encrypted )	
 -------------------------------------------------------------------------------------------------------------------*/	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("rahul").password(this.passwordEncoder().encode("rahul1")).roles("ADMIN","NORMAL");		// Giving multiple ROLEs to ADMIN => So that admin can access "/admin/**" Url pages, and as well "/users/**" Url pages
		auth.inMemoryAuthentication().withUser("vikas").password(this.passwordEncoder().encode("vikas1")).roles("NORMAL");				// bydefault role me "ROLE_" already append rehta hai.
	}

/* 	Encrypting password through "BCryptPasswordEncoder"
 -------------------------------------------------------------------------------------------------------------------*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	
	
/* 	"ROLE" means High Level Overview
  			NormalUser : will only READ
  			
 * 	"AUTHORITY" means Permission -> READ/ WRITE/ UPDATE			
 -------------------------------------------------------------------------------------------------------------------*/
	
	
	
	
	
}
