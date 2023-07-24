package com.example.springdemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.springdemo.dto.BookDTO;
import com.example.springdemo.entity.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    @Mapping(target="title", source="book.title")
    BookDTO toDTO(Book book);

    @Mapping(target="title", source="bookDTO.title")
    Book toEntity(BookDTO bookDTO);
}
