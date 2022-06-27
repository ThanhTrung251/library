package com.example.lib.service;

import com.example.lib.model.entity.Author;
import com.example.lib.model.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAllAuthor();

    Author creatAuthor(Author author);

    Author updateAuthor(long id,Author author);

    void deleteAuthor(long id);

    Author getAuthorById();
}
