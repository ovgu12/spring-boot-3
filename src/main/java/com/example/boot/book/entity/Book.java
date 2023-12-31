package com.example.boot.book.entity;

import com.example.boot.author.entity.Author;
import com.example.boot.common.TrimConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @SequenceGenerator(name = "book_id_generator", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(generator = "book_id_generator")
    private Long id;

    @Convert(converter = TrimConverter.class)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
