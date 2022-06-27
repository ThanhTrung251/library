package com.example.lib.model.dto;

import com.example.lib.utils.enum_type.BookStatus;
import lombok.*;

import java.util.List;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {

    private Long id;

    private String subject;

    private String title;

    private int pages;

    private int numberOfBook;

    private int copyright;

    private int edition;

    private String library;

    private LocalDate creatAt;

    private BookStatus bookStatus;

    private Long publisherID;

    private List<Long> authorIds;

}
