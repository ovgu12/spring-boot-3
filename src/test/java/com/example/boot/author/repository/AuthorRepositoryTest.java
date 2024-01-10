package com.example.boot.author.repository;

import com.example.boot.author.entity.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorRepository.deleteAll();
    }

    @Test
    public void contextLoads() {
        var author = new Author();
        author.setName("Hello");
        authorRepository.save(author);
        assertNotNull(authorRepository);
        assertEquals(1, authorRepository.findAll().size());
    }

    @AfterEach
    void tearDown() {
    }

}