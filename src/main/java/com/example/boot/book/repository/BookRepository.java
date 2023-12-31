package com.example.boot.book.repository;

import com.example.boot.author.entity.Author;
import com.example.boot.book.entity.Book;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Lock(LockModeType.OPTIMISTIC)
    List<Book> findAllByAuthor(Author author);

    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.author a")
    List<Book> queryAll();

}
