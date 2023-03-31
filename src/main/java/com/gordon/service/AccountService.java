package com.gordon.service;

import com.gordon.mapper.AccountMapper;
import com.gordon.model.Account;
import com.gordon.dto.AccountDto;
import com.gordon.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {

  private final AccountRepository accountRepository;
  private final AccountMapper accountMapper;


  public AccountDto getAccountDetails(Long id) {

    Account accountFromDb = accountRepository.findByCustomerId(id).orElseThrow(
        () -> new UsernameNotFoundException(String.format("user id %s not found", id)));
    return accountMapper.toDto(accountFromDb);
  }
}
