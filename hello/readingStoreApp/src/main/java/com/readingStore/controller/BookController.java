package com.readingStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readingStore.Dto.BookDto;
import com.readingStore.entity.Book;
import com.readingStore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	 @PostMapping("/new")
	 public ResponseEntity<String>newBook( @RequestBody Book b) { 
		 bookService.save(b); 
		 return ResponseEntity.status(HttpStatus.CREATED).body("Created"); }
	 
	 @GetMapping("/get/all")
	 public ResponseEntity<List<Book>> getAllBooks() {
		 List<Book> allBooks =  bookService.getAllBooks();
		 return ResponseEntity.status(HttpStatus.OK).body(allBooks);
	 }
	 
	 @GetMapping("/get/{id}")
	 public ResponseEntity<BookDto> getBookById(@PathVariable int id) {
	       BookDto b = bookService.getBookById(id);
	       return ResponseEntity.status(HttpStatus.FOUND).body(b);
	 }
	 
	 @PutMapping("/edit/{id}")
	 public ResponseEntity<String> editBook(@PathVariable int id,@RequestBody Book b){
		 bookService.updateBook(id ,b);
		 return ResponseEntity.status(HttpStatus.OK).body("Modifed");
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteBook(@PathVariable int   id) {
		 bookService.deleteBookById(id);
		return ResponseEntity.status(HttpStatus.GONE).body("Deleted");
	 }
	 
	 @PostMapping("/{bookId}/take/{userId}")
	 public ResponseEntity<Book> takeBook (@PathVariable int bookId,@PathVariable int userId){
		 return ResponseEntity.ok(bookService.takeBook(bookId, userId));
		 
	 }

}