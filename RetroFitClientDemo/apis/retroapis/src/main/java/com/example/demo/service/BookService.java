package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.models.UserBook;
import com.example.demo.repository.BookRepo;
import com.example.demo.daos.BookDao;
import com.example.demo.gateway.Gateway;
import com.example.demo.mapper.*;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private Gateway gateway;

	public Optional<Book> addBook(Book book) {
		BookDao bookDb = bookRepo.findByName(book.getName());
		if (bookDb == null) {
			BookDao bd = Mapper.BookToBookDao(book);
			bd.setCreated(new Date());
			bd.setUpdated(new Date());
			Book bookRes = Mapper.BookDaoToBook(bookRepo.save(bd));
			return Optional.of(bookRes);
		}
		return Optional.empty();
	}

	public Optional<UserBook> getBookDetails(UUID bookId) {
		try {
			BookDao book = bookRepo.getById(bookId);
			UserBook ub = new UserBook();
			if (book.getUserId() != null) {
				Optional<User> user = gateway.getUser(book.getUserId());
				if (user.isEmpty()) {
					return Optional.empty();
				}
				ub.setUser(user.get());
				ub.setBook(Mapper.BookDaoToBook(book));
			} else if (book.getUserId() == null) {
				ub.setBook(Mapper.BookDaoToBook(book));
			}
			return Optional.of(ub);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	public Optional<UserBook> assignBookToUser(UUID bookId, String userEmail) {
		try {
			Optional<User> user = gateway.getUserByEmail(userEmail);
			BookDao book = bookRepo.getById(bookId);
			if (user.isPresent()) {
				book.setUserId(user.get().getId());
				bookRepo.save(book);
				UserBook ub = new UserBook();
				ub.setUser(user.get());
				ub.setBook(Mapper.BookDaoToBook(book));
				return Optional.of(ub);
			}
		}catch(Exception e) {
			return Optional.empty();
		}
		return Optional.empty();
	}

	public Optional<List<Book>> getAllBooks() {
		List<BookDao> list = bookRepo.findAll();
		if (list == null) {
			return Optional.empty();
		}
		List<Book> listBook = new ArrayList<>();
		for (BookDao bd : list) {
			listBook.add(Mapper.BookDaoToBook(bd));
		}
		return Optional.of(listBook);
	}

	public Optional<Book> deleteBook(UUID bookId) {
		try {
			BookDao bookDao = bookRepo.getById(bookId);
			bookRepo.delete(bookDao);
			return Optional.of(Mapper.BookDaoToBook(bookDao));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	public Optional<Book> clearIssueBook(UUID bookId) {
		try {
			BookDao bookDao = bookRepo.getById(bookId);
			bookDao.setUserId(null);
			bookRepo.save(bookDao);
			return Optional.of(Mapper.BookDaoToBook(bookDao));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

}
