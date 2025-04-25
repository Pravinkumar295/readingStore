package com.readingStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readingStore.Dto.BookDto;
import com.readingStore.entity.Book;
import com.readingStore.entity.User;
import com.readingStore.exception.ResourseNotFoundException;
import com.readingStore.repository.BookRepository;
import com.readingStore.repository.UserRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void save(Book b) {
		bookRepository.save(b);
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	public Book getBooksById(int id) {
		
		return bookRepository.getReferenceById(id);
	}

	public void updateBook(int id, Book b) {
		Optional<Book> bookDetails = bookRepository.findById(id);
		Book newBook = bookDetails.get();
		newBook.setAuthorName(b.getAuthorName());
		newBook.setBookName(b.getBookName());
		newBook.setGenre(b.getGenre());
		newBook.setNoOfPages(b.getNoOfPages());
		newBook.setPrice(b.getPrice());
		
		bookRepository.save(newBook);
	}
	public BookDto getBookById(int id) {
		Book b = bookRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Book not found with the id:"+id));
		BookDto bd = new BookDto();
		bd.setAuthorName(b.getAuthorName());
		bd.setBookName(b.getBookName());
		bd.setId(b.getId());
		bd.setPrice(b.getPrice());
		bd.setNoOfPages(b.getNoOfPages());
		bd.setGenre(b.getGenre());
		return bd;
	}

	public void deleteBookById(int id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
		
	}
	
	public Book takeBook(int bookId,int userId) {
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
		Book book = bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book Not Found"));
		book.setUser(user);
		return bookRepository.save(book);
	}
	
	public List<Book> getBooksTakenByUser(int user_id){
		User user = userRepository.getReferenceById(user_id);
		return bookRepository.findByUser(user);
		
	}
}
