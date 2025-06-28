package com.example.LibraryApplication.repository;

import com.example.LibraryApplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
