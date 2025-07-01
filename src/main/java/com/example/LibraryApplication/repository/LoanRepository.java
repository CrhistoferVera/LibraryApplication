package com.example.LibraryApplication.repository;

import com.example.LibraryApplication.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository  extends JpaRepository<Loan, Long> {

    @Query(value = "SELECT * FROM loan WHERE loan.user_id= :idUser AND  loan.returned= false",nativeQuery = true)
    List<Loan> findLoansNotReturnedByUser(@Param("idUser") Long idUser);
}
