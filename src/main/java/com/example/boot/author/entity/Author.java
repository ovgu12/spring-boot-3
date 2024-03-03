package com.example.boot.author.entity;

import com.example.boot.book.entity.Book;
import com.example.boot.common.TrimConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(generator = "author_id_generator")
    @SequenceGenerator(name = "author_id_generator", sequenceName = "author_sequence", allocationSize = 1)
    private Long id;

    @Size(min = 3, max = 50)
    @Convert(converter = TrimConverter.class)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books;

}
