package com.example.LibraryApplication.service;

import com.example.LibraryApplication.dto.BookDTO;
import com.example.LibraryApplication.dto.CreateBookDTO;

import java.util.List;

public interface BookService {
    BookDTO create(CreateBookDTO dto);
    void delete(Long id);
    BookDTO findById(Long id);
    List<BookDTO> findAll();

}
