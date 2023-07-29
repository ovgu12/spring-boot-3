package com.example.springdemo.book.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.author.repository.AuthorRepository;
import com.example.springdemo.book.dto.BookDTO;
import com.example.springdemo.book.mapper.BookMapper;
import com.example.springdemo.book.repository.BookRespository;

@Service
public class BookService {

    @Autowired
    private BookRespository bookRespository;

    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> list() {
        return bookRespository.findAll().stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public void create(BookDTO bookDTO) {
        var book = bookMapper.toEntity(bookDTO);
        var author = authorRepository.getReferenceById(1L);
        var books = author.getBooks();
        books.add(book);
        author.setBooks(books);
        book.setAuthor(author);
        bookRespository.save(book);
    }

    public BookDTO getById(Long bookId) {
        return bookMapper.toDTO(bookRespository.getReferenceById(bookId));
    }

    public void deleteById(Long bookId) {
        bookRespository.deleteById(bookId);
    }

    public void deleteByAuthorId(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
