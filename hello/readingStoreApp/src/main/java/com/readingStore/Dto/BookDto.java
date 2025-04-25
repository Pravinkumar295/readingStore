package com.readingStore.Dto;

import com.readingStore.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDto {
	
	int id;
	String bookName;
	String authorName;
	String price;
	String genre;
	int noOfPages;
	public BookDto(Book book) {
		super();
		this.id = book.getId();
		this.bookName =book.getBookName();
		this.authorName = book.getAuthorName();
		this.price = book.getPrice();
		this.genre = book.getGenre();
		this.noOfPages = book.getNoOfPages();
	}
	
}
