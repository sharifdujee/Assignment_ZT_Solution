package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class UserController {
	@Autowired
	private UserService userservice;

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userservice.createuser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);

	}

}
