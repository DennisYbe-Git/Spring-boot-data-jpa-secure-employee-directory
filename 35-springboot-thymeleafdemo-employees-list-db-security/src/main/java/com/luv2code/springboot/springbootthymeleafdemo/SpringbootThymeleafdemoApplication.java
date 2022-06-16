package com.luv2code.springboot.springbootthymeleafdemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;


@SpringBootApplication
public class SpringbootThymeleafdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafdemoApplication.class, args);
	}
	
	// Localize the thymeleaf html templates
	// expose the Localization resource bundle messages in view html pages (Thymeleaf templates)
	// use attribute th:text="#{label.title}" in html  tags to access the keys in message.properties bundle
	@Bean("messageSource")
	public MessageSource getMessageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("resourceBundle/messages");
		
		return messageSource;
		
	}

}
