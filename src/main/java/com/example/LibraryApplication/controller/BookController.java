package com.example.LibraryApplication.controller;

import com.example.LibraryApplication.dto.BookDTO;
import com.example.LibraryApplication.dto.CreateBookDTO;
import com.example.LibraryApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> createBook( @RequestBody CreateBookDTO dto){
        BookDTO bookDTO = bookService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping
    public List<BookDTO> findAll(){
        return bookService.findAll();
    }
}
