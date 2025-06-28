package com.example.LibraryApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookDTO {
    private String title;
    private String author;
    private String isbn;
}
