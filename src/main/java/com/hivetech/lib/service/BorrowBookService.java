package com.hivetech.lib.service;


import com.hivetech.lib.model.dto.BorrowBookDTO;
import com.hivetech.lib.model.dto.BorrowedBook;
import com.hivetech.lib.model.entity.BorrowBook;
import com.hivetech.lib.model.request.BorrowBookRequest;

import java.util.List;

public interface BorrowBookService {
    List<BorrowedBook> getAllBorrowBook(String keyword);

    BorrowBook createReverseBook(BorrowBookRequest borrowBookRequest);

    BorrowBook updateBorrowBook(long id, BorrowBook borrowBook);

    BorrowBookDTO returnBorrowBook(long id);

    BorrowBookDTO getBorrowBookById(long id);

    BorrowBook creatBorrowBook(BorrowBookRequest borrowBookRequest);
}
