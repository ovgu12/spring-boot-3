package com.example.boot.author.controller;

import com.example.boot.author.dto.AuthorDTO;
import com.example.boot.author.service.AuthorService;
import com.example.boot.book.dto.BookDTO;
import com.example.boot.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<AuthorDTO> list() {
        return authorService.list();
    }

    @PostMapping
    public void create(@RequestBody AuthorDTO authorDTO) {
        authorService.create(authorDTO);
    }

    @DeleteMapping(value = "/{authorId}")
    public void deleteByAuthor(@PathVariable("authorId") Long authorId) {
        authorService.deleteByAuthorId(authorId);
    }

    @PostMapping(value = "/{authorId}/books")
    public void createBook(@PathVariable("authorId") Long authorId, @RequestBody BookDTO bookDTO) {
        bookService.createByAuthorId(authorId, bookDTO);
    }

}
