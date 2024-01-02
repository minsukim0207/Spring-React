package com.kh.springchap01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springchap01.model.Users;
import com.kh.springchap01.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users newUser) {
		Users createdUser = userRepository.save(newUser);
		return ResponseEntity.ok(createdUser);
	}
}
