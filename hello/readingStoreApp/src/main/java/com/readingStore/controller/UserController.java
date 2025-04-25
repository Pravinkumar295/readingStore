package com.readingStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readingStore.entity.User;
import com.readingStore.service.BookService;
import com.readingStore.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/new")
	public ResponseEntity<String> newUser(@RequestBody User u) {
		userService.save(u);
		return ResponseEntity.status(HttpStatus.CREATED).body("Created");
	}
	
	/*
	 * @GetMapping("/{userId}/books") public ResponseEntity<List<Book>>
	 * getBooksTakenByUser(@PathVariable int userId){ return
	 * ResponseEntity.ok(bookService.getBooksTakenByUser(userId)); }
	 */
}
