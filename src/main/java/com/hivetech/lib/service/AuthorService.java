package com.hivetech.lib.service;

import com.hivetech.lib.model.dto.AuthorDTO;
import com.hivetech.lib.model.entity.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAllAuthor();

    Author creatAuthor(Author author);

    Author updateAuthor(long id,Author author);

    void deleteAuthor(long id);

    Author getAuthorById();
}
