package com.hivetech.lib.repository;

import com.hivetech.lib.model.entity.AuthorBook;
import com.hivetech.lib.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorBookRepository extends JpaRepository<AuthorBook, Long> {
    List<AuthorBook> findByBook(Book book);
}
