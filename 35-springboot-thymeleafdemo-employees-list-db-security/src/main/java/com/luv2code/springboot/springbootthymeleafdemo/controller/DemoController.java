package com.luv2code.springboot.springbootthymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(method=RequestMethod.GET, value="/demo")
//@RequestMapping("/demo")
public class DemoController {
	
	// Get Mapping for hello world endpoint
	//
	@GetMapping("/hello_Local")
	public String sayHello(Model model) {
		
		model.addAttribute("theDate", new Date());
		// Spring data thymeleaf auto configures view resolver to 
		// get helloworld.html template file from src/main/resources/templates
		return "helloworld";
	}

}
