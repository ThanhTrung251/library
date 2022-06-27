package com.hivetech.lib.repository;

import com.hivetech.lib.model.dto.BorrowedBook;
import com.hivetech.lib.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(Long idAuthor);
}
