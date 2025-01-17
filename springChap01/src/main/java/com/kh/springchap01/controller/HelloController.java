package com.kh.springchap01.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true")
public class HelloController {

	@GetMapping("/hello")
	public String getHello() {
		return "Hello World";
	}
	
	@GetMapping("/java")
	public String getJava() {
		return "Java";
	}
}
