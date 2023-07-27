package com.example.springdemo.book.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.springdemo.book.dto.BookDTO;
import com.example.springdemo.book.entity.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    @Mapping(target="title", source="book.title")
    BookDTO toDTO(Book book);

    @Mapping(target="title", source="bookDTO.title")
    Book toEntity(BookDTO bookDTO);
}
