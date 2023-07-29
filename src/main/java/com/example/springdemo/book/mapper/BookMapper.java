package com.example.springdemo.book.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.springdemo.book.dto.BookDTO;
import com.example.springdemo.book.entity.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    @Mapping(target="authorName", source="book.author.name")
    BookDTO toDTO(Book book);

    @Mapping(target="author", ignore=true)
    Book toEntity(BookDTO bookDTO);
}
