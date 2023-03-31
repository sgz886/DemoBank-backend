package com.gordon.controller;

import com.gordon.dto.AccountDto;
import com.gordon.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountController {

  private final AccountService accountService;
  @GetMapping("/myAccount")
  public AccountDto getAccount(@RequestParam Long id) {
    return accountService.getAccountDetails(id);
  }
}
