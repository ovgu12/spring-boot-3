package com.example.boot.book.mapper;

import com.example.boot.book.dto.BookDTO;
import com.example.boot.book.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(target = "authorName", source = "book.author.name")
    BookDTO toDTO(Book book);

    @Mapping(target = "author", ignore = true)
    Book toEntity(BookDTO bookDTO);

}
