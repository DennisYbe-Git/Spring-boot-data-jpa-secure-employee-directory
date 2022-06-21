package com.luv2code.springboot.springbootthymeleafdemo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	
	@Autowired
	private MessageSource messageSource;
	
	//static Logger logger = Logger.getLogger("demo-07");
	
	@GetMapping("/access-denied")
	public String accessDenied(Model theModel, Principal user) {
		//logger.log(Level.WARNING, "--- user:"+user.getName()+", Access Denied error");
		System.out.println("User name:"+user.getName());
		Object[] objects = {user.getName()};
		theModel.addAttribute("accessErrorMsg", messageSource.getMessage("label.access.denied", objects, null));
		return "access-denied";
	}

}
