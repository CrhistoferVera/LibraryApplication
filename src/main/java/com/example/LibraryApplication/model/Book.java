package com.example.LibraryApplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String author;
    private String isbn;
    private boolean available = true;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans = new ArrayList<>();


}
