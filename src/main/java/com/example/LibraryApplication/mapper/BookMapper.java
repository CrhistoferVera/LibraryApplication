package com.example.LibraryApplication.mapper;

import com.example.LibraryApplication.dto.BookDTO;
import com.example.LibraryApplication.dto.CreateBookDTO;
import com.example.LibraryApplication.model.Book;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book book);
    Book toEntity(BookDTO dto);
    Book toEntity(CreateBookDTO dto);
    List<BookDTO> toDTOs(List<Book> l);
}
