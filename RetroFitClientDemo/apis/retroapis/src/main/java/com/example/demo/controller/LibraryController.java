package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;
import com.example.demo.models.*;

@RestController
@RequestMapping("/api/v1/lib")
public class LibraryController {

	@Autowired
	private BookService bookService;

	@GetMapping("/list")
	public ResponseEntity<List<Book>> allBooks() {
		Optional<List<Book>> bookList = bookService.getAllBooks();
		if (bookList.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(bookList.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping("")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Optional<Book> bookDb = bookService.addBook(book);
		if (bookDb.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(bookDb.get());
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<UserBook> getBook(@PathVariable("bookId") UUID bookId) {
		Optional<UserBook> user = bookService.getBookDetails(bookId);
		if (user.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(user.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@DeleteMapping("{bookId}")
	public ResponseEntity<Book> removeBook(@PathVariable("bookId") UUID bookId){
		Optional<Book> bookDb = bookService.deleteBook(bookId);
		if(bookDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(bookDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/clear/{bookId}")
	public ResponseEntity<Book> unsignBookIssue(@PathVariable("bookId") UUID bookId){
		Optional<Book> bookDb = bookService.clearIssueBook(bookId);
		if(bookDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(bookDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/issue/{bookId}")
	public ResponseEntity<UserBook> issueBook(@PathVariable("bookId") UUID bookId,
			@RequestParam("email") String userEmail) {
		Optional<UserBook> user = bookService.assignBookToUser(bookId, userEmail);
		if (user.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(user.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
