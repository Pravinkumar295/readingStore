package com.readingStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readingStore.entity.Admin;
import com.readingStore.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/new")
	public ResponseEntity<String> setAdmin( @RequestBody Admin a){
		adminService.save(a);
		return ResponseEntity.status(HttpStatus.CREATED).body("Created");
	}
}
