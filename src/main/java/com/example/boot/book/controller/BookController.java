package com.example.boot.book.controller;

import com.example.boot.book.dto.BookDTO;
import com.example.boot.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.list();
    }

    @GetMapping(value = "/{bookId}")
    public BookDTO getBook(@PathVariable("bookId") Long bookId) {
        return bookService.getById(bookId);
    }

    @DeleteMapping(value = "/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteById(bookId);
    }

}
