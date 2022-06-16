package com.luv2code.springboot.springbootthymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLogin")
	public String showLoginPage() {
		
		return "customLogin";
	}

}
