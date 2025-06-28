package com.example.LibraryApplication.service;

import com.example.LibraryApplication.dto.CreateLoanDTO;
import com.example.LibraryApplication.dto.LoanDTO;

import java.util.List;

public interface LoanService {
    LoanDTO createLoan(CreateLoanDTO dto);
    LoanDTO returnBook(Long loanId);
    void delete(Long id);
    LoanDTO findLoanById(Long id);
    List<LoanDTO> findAllLoans();
    List<LoanDTO> findLoansByUserId(Long userId);
    List<LoanDTO> findLoansByBookId(Long bookId);


}
