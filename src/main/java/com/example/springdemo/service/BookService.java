package com.example.springdemo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.dto.BookDTO;
import com.example.springdemo.mapper.BookMapper;
import com.example.springdemo.repository.BookRespository;

@Service
public class BookService {

    @Autowired
    private BookRespository bookRespository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> list() {
        return bookRespository.findAll().stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }
}
