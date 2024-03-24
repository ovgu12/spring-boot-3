package com.example.boot.book.service;

import com.example.boot.author.repository.AuthorRepository;
import com.example.boot.book.dto.BookDTO;
import com.example.boot.book.mapper.BookMapper;
import com.example.boot.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final BookMapper bookMapper;

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
