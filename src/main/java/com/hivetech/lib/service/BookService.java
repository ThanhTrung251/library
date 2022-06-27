package com.hivetech.lib.service;

import com.hivetech.lib.model.dto.BookAfterFilter;
import com.hivetech.lib.model.dto.BookDTO;
import com.hivetech.lib.model.request.BookRequest;
import com.hivetech.lib.model.request.SearchBookForm;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBook();

    BookDTO createBook(BookRequest bookRequest);

    List<BookAfterFilter> listAllBook();

    List<BookAfterFilter> searchBook(SearchBookForm request);

    BookDTO updateBook(long id, BookRequest bookRequest);

    Boolean deleteBook(long id);

    BookDTO getBookById(long id);

    List<BookDTO> getAllBookAvailable();
}
