package com.example.boot.book.service;

import com.example.boot.author.repository.AuthorRepository;
import com.example.boot.book.dto.BookDTO;
import com.example.boot.book.mapper.BookMapper;
import com.example.boot.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> list() {
        return bookRepository.findAll().stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createByAuthorId(Long authorId, BookDTO bookDTO) {
        var book = bookMapper.toEntity(bookDTO);
        var author = authorRepository.getReferenceById(authorId);
        var books = author.getBooks();
        books.add(book);
        author.setBooks(books);
        book.setAuthor(author);
        bookRepository.save(book);
    }

    public BookDTO getById(Long bookId) {
        return bookMapper.toDTO(bookRepository.getReferenceById(bookId));
    }

    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
