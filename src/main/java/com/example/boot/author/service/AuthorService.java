package com.example.boot.author.service;

import com.example.boot.author.dto.AuthorDTO;
import com.example.boot.author.mapper.AuthorMapper;
import com.example.boot.author.repository.AuthorRepository;
import com.example.boot.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    public List<AuthorDTO> list() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    public void create(AuthorDTO authorDTO) {
        final var author = authorMapper.toEntity(authorDTO);
        authorRepository.save(author);
    }

    public void deleteByAuthorId(Long authorId) {
        final var author = authorRepository.getReferenceById(authorId);
        authorRepository.delete(author);
    }

}
