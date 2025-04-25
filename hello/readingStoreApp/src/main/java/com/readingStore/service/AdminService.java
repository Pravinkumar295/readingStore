package com.readingStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readingStore.entity.Admin;
import com.readingStore.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	
	public void save(Admin a) {
		adminRepository.save(a);
	}

}
