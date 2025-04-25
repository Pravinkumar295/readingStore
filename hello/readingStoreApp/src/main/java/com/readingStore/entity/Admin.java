package com.readingStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int users_count;
	private int books_count;
	public Admin(int id, String name, int users_count, int books_count) {
		super();
		this.id = id;
		this.name = name;
		this.users_count = users_count;
		this.books_count = books_count;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUsers_count() {
		return users_count;
	}
	public void setUsers_count(int users_count) {
		this.users_count = users_count;
	}
	public int getBooks_count() {
		return books_count;
	}
	public void setBooks_count(int books_count) {
		this.books_count = books_count;
	}
	
	
}