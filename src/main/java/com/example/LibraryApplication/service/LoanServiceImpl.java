package com.example.LibraryApplication.service;

import com.example.LibraryApplication.dto.CreateLoanDTO;
import com.example.LibraryApplication.dto.LoanDTO;
import com.example.LibraryApplication.exception.IllegalStateException;
import com.example.LibraryApplication.exception.LoanAlreadyReturnedException;
import com.example.LibraryApplication.exception.ResourceNotFoundException;
import com.example.LibraryApplication.mapper.LoanMapper;
import com.example.LibraryApplication.model.Book;
import com.example.LibraryApplication.model.Loan;
import com.example.LibraryApplication.model.User;
import com.example.LibraryApplication.repository.BookRepository;
import com.example.LibraryApplication.repository.LoanRepository;
import com.example.LibraryApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService{
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Override
    public LoanDTO createLoan(CreateLoanDTO dto) {
        Long userId = dto.getUserId();
        Long bookId = dto.getBookId();
        User user   = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: "+userId));
        Book book   = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: "+bookId));
        if(!book.isAvailable()) {
            throw new IllegalStateException("Book with ID " + bookId + " is not available for loan");
        }
        book.setAvailable(false);
        bookRepository.save(book);
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setUser(user);
        loan.setLoanDate(LocalDate.now());
        return loanMapper.toDTO(loanRepository.save(loan));
    }

    @Override
    public LoanDTO returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("The loan with ID: "+loanId+" was not found"));
        if(loan.getReturnDate() != null){
            throw new LoanAlreadyReturnedException("The loan with ID: "+loanId+" is already returned");
        }
        loan.setReturnDate(LocalDate.now());
        Book book= loan.getBook();
        book.setAvailable(true);
        bookRepository.save(book);
        return loanMapper.toDTO(loanRepository.save(loan));
    }

    @Override
    public void delete(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public LoanDTO findLoanById(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan Not Found"));
        return loanMapper.toDTO(loan);
    }

    @Override
    public List<LoanDTO> findAllLoans() {
        return loanMapper.toDTOs(loanRepository.findAll());
    }

    @Override
    public List<LoanDTO> findLoansByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        return loanMapper.toDTOs(user.getLoans());
    }

    @Override
    public List<LoanDTO> findLoansByBookId(Long bookId) {
        Book book   = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book Not Found"));
        return loanMapper.toDTOs(book.getLoans());
    }



}
