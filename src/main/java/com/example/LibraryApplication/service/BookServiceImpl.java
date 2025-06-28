package com.example.LibraryApplication.service;

import com.example.LibraryApplication.dto.BookDTO;
import com.example.LibraryApplication.dto.CreateBookDTO;
import com.example.LibraryApplication.exception.ResourceNotFoundException;
import com.example.LibraryApplication.mapper.BookMapper;
import com.example.LibraryApplication.model.Book;
import com.example.LibraryApplication.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper){
        this.bookRepository=bookRepository;
        this.bookMapper=bookMapper;
    }

    @Override
    public BookDTO create(CreateBookDTO dto) {
        Book book = bookMapper.toEntity(dto);
        book.setAvailable(true);
        return bookMapper.toDTO(bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with Id:"+ id));
        bookRepository.delete(book);
    }

    @Override
    public BookDTO findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with Id:"+ id));
        return bookMapper.toDTO(book);
    }

    @Override
    public List<BookDTO> findAll() {
        return bookMapper.toDTOs(bookRepository.findAll());
    }
}
