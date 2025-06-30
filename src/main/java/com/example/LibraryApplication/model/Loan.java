package com.example.LibraryApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @Column(nullable = false)
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private BigDecimal fineAmount;
}
