package com.example.LibraryApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanDTO {
    private Long userId;
    private Long bookId;
}
