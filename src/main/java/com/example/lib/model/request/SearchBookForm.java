package com.example.lib.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SearchBookForm {
    private String keyword;
    private String available;
    private String borrow;
    private String reserve;
    private int edition;
}
