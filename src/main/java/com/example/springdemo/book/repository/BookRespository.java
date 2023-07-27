package com.example.springdemo.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.book.entity.Book;

public interface BookRespository extends JpaRepository<Book, Long> {
    
}
