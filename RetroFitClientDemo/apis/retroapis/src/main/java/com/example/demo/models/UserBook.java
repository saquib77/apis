package com.example.demo.models;

public class UserBook {
	private Book book;
	private User user;
	public UserBook() {
		super();
	}
	public UserBook(Book book, User user) {
		super();
		this.book = book;
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserBook [book=" + book + ", user=" + user + "]";
	}
	
}
