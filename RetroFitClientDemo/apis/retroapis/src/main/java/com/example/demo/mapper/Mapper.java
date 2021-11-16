package com.example.demo.mapper;

import org.springframework.beans.BeanUtils;

import com.example.demo.daos.BookDao;
import com.example.demo.models.Book;

public class Mapper {
	public static Book BookDaoToBook(BookDao bd) {
		Book b = new Book();
		BeanUtils.copyProperties(bd, b);
		return b;
	}

	public static BookDao BookToBookDao(Book bd) {
		BookDao b = new BookDao();
		BeanUtils.copyProperties(bd, b);
		return b;
	}
}
