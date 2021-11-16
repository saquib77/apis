package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.daos.BookDao;

public interface BookRepo extends JpaRepository<BookDao, UUID> {

	BookDao findByName(String name);

}
