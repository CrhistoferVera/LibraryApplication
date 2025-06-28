package com.example.LibraryApplication.mapper;

import com.example.LibraryApplication.dto.LoanDTO;
import com.example.LibraryApplication.model.Loan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanDTO toDTO(Loan loan);
    Loan toEntity(LoanDTO dto);
    List<LoanDTO> toDTOs(List<Loan> list);
}
