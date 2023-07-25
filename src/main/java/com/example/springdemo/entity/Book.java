package com.example.springdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @SequenceGenerator(name = "book_id_generator", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(generator = "book_id_generator")
    private Long id;

    private String title;
}
