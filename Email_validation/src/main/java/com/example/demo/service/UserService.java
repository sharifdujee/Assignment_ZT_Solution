package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepo; 
		
		public User createuser (User user) {
			return userrepo.save(user);
		
	}

}
