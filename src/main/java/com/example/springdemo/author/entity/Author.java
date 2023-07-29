package com.example.springdemo.author.entity;

import java.util.Set;

import com.example.springdemo.book.entity.Book;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @SequenceGenerator(name = "author_id_generator", sequenceName = "author_sequence", allocationSize = 1)
    @GeneratedValue(generator = "author_id_generator")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;
}
