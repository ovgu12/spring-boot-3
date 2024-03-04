package com.example.boot.author.mapper;

import com.example.boot.author.dto.AuthorDTO;
import com.example.boot.author.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper {

    @Mapping(target = "name")
    Author toEntity(AuthorDTO authorDTO);

    @Mapping(target = "id")
    @Mapping(target = "name")
    AuthorDTO toDto(Author author);

}