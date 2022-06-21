package com.luv2code.springboot.springbootthymeleafdemo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// create the in-memory users, passwords and roles
		// Use password in plain-text
//		UserBuilder users = User.withDefaultPasswordEncoder();
//
//		auth.inMemoryAuthentication()
//		.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//		.withUser(users.username("mary").password("test123").roles("MANAGER"))
//		.withUser(users.username("susan").password("test123").roles("ADMIN"));
		
		auth.jdbcAuthentication().dataSource(dataSource);
				
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.antMatchers("/demo/hello").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
		.antMatchers("/employees/list").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
		.antMatchers("/employees/showFormAdd").hasAnyRole("ADMIN","MANAGER")
		.antMatchers("/employees/showFormUpdate").hasAnyRole("ADMIN","MANAGER")
		.antMatchers("/employees/delete").hasRole("ADMIN")
		// provide a custom access denied page when used is no authorized.
		.and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied")
		.and()
		.formLogin()
		.loginPage("/showLogin")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout().permitAll(); // default logout URL /logout
		
	}
	
	

}
