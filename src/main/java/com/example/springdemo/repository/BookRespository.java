package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.entity.Book;

public interface BookRespository extends JpaRepository<Book, Long> {
    
}
