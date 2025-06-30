package com.example.LibraryApplication.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanDTO {

    @Positive
    private Long userId;

    @Positive
    private Long bookId;

    @Positive
    private Long days;
}
