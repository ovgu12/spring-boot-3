package com.example.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.dto.BookDTO;
import com.example.springdemo.service.BookService;

@RestController
public class DefaultController { 

    @Autowired
    private BookService bookService;
    
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> getBooks() {
        return bookService.list();
    }
    
}
