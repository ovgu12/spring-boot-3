package com.example.springdemo.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.author.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
