package com.example.LibraryApplication.repository;

import com.example.LibraryApplication.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository  extends JpaRepository<Loan, Long> {

}
