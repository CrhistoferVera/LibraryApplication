package com.example.LibraryApplication.controller;

import com.example.LibraryApplication.dto.CreateLoanDTO;
import com.example.LibraryApplication.dto.LoanDTO;
import com.example.LibraryApplication.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final  LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanDTO> createLoan(@RequestBody CreateLoanDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(dto));
    }

    @PutMapping("/return/{loanId}")
    public ResponseEntity<LoanDTO> returnBook(@PathVariable Long loanId){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.returnBook(loanId));
    }

    @DeleteMapping("/{loanId}")
    public void deleteLoan(@PathVariable Long loanId){
        loanService.delete(loanId);
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanDTO> findLoanById(@PathVariable Long loanId){
        return ResponseEntity.ok(loanService.findLoanById(loanId));
    }

    @GetMapping
    public List<LoanDTO> findAllLoans(){
        return loanService.findAllLoans();
    }

    @GetMapping("/user/{userId}")
    public List<LoanDTO> findLoansByUserId(@PathVariable Long userId){
        return loanService.findLoansByUserId(userId);
    }

    @GetMapping("/book/{bookId}")
    public List<LoanDTO> findLoansByBookId(@PathVariable Long bookId){
        return loanService.findLoansByBookId(bookId);
    }
}
