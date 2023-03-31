package com.gordon.service;

import com.gordon.dto.AccountTransactionDto;
import com.gordon.mapper.AccountTransactionMapper;
import com.gordon.model.AccountTransaction;
import com.gordon.repository.AccountTransactionRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BalanceService {

  private final AccountTransactionRepository accountTransactionRepository;
  private final AccountTransactionMapper accountTransactionMapper;

  public List<AccountTransactionDto> getBalanceDetail(Long id) {
    List<AccountTransaction> accountTransactions = accountTransactionRepository.findByCustomerIdOrderByTransactionDtDesc(
        id);
    return accountTransactions.stream().map(accountTransactionMapper::toDto).collect(Collectors.toList());
  }
}
