package com.readingStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readingStore.entity.User;
import com.readingStore.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void save(User u) {
		userRepository.save(u);
	}
}
