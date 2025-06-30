package com.example.LibraryApplication.controller;

import com.example.LibraryApplication.dto.BookDTO;
import com.example.LibraryApplication.dto.CreateBookDTO;
import com.example.LibraryApplication.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Validated
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody CreateBookDTO dto){
        BookDTO bookDTO = bookService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id){
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable @Min(1) Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping
    public List<BookDTO> findAll(){
        return bookService.findAll();
    }
}
