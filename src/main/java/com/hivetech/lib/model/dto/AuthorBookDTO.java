package com.hivetech.lib.model.dto;

import com.hivetech.lib.model.entity.Author;
import com.hivetech.lib.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorBookDTO {
    private  Long id;

    private AuthorDTO authorDTO;

    private BookDTO bookDTO;
}
