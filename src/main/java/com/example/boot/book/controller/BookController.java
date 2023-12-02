package com.example.boot.book.controller;

import com.example.boot.book.dto.BookDTO;
import com.example.boot.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.list();
    }

    @GetMapping(value = "/{bookId}")
    public BookDTO getBook(@PathVariable("bookId") String bookId) {
        return bookService.getById(Long.valueOf(bookId));
    }

    @PostMapping
    public void createBook(@RequestBody BookDTO bookDTO, @RequestParam String authorId) {
        bookService.create(bookDTO, Long.valueOf(authorId));
    }

    @DeleteMapping(value = "/{bookId}")
    public void deleteBook(@PathVariable("bookId") String bookId) {
        bookService.deleteById(Long.valueOf(bookId));
    }

}
