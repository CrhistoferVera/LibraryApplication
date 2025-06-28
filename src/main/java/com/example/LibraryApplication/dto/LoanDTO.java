package com.example.LibraryApplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
    private Long id;
    private UserDTO user;
    private BookDTO book;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
