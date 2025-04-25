package com.readingStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.readingStore.entity.Book;
import com.readingStore.entity.User;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findByUser(User user);

}
