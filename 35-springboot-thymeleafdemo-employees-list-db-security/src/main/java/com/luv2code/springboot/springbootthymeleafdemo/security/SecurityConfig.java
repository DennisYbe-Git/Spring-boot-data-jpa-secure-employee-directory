package com.luv2code.springboot.springbootthymeleafdemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		
		// create the in-memory users, passwords and roles
		// Use password in plain-text
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("test123").roles("MANAGER"))
		.withUser(users.username("susan").password("test123").roles("ADMIN"));
				
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.antMatchers("/employees/list").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
		.antMatchers("/employees/showFormAdd").hasAnyRole("ADMIN","MANAGER")
		.antMatchers("/employees/showFormUpdate").hasAnyRole("ADMIN")
		.antMatchers("/employees/delete").hasRole("ADMIN")
		.and()
		.formLogin()
		.loginPage("/showLogin")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout().permitAll(); // default logout URL /logout
		
	}
	
	

}
