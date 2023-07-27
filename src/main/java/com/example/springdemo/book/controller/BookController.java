package com.example.springdemo.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.book.dto.BookDTO;
import com.example.springdemo.book.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
;
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> getBooks() {
        return bookService.list();
    }

    @GetMapping(value = "/{bookId}")
    public BookDTO getBook(@PathVariable("bookId") String bookId) {
        return bookService.getById(Long.valueOf(bookId));
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDTO bookDTO) {
        bookService.create(bookDTO);
    }

    @DeleteMapping(value = "/{bookId}")
    public void deleteBook(@PathVariable("bookId") String bookId) {
        bookService.deleteById(Long.valueOf(bookId));
    }

}
