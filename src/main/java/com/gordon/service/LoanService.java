package com.gordon.service;

import com.gordon.dto.LoanDto;
import com.gordon.mapper.LoanMapper;
import com.gordon.model.Loan;
import com.gordon.repository.LoanRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

  private final LoanRepository loanRepository;
  private final LoanMapper loanMapper;

  public List<LoanDto> getLoans(Long id) {
    List<Loan> loans = loanRepository.findByCustomerId(id);
    return loans.stream().map(loanMapper::toDto).collect(Collectors.toList());
  }

}
