package com.gordon.controller;

import com.gordon.dto.AccountTransactionDto;
import com.gordon.service.BalanceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BalanceController {

  private final BalanceService balanceService;

  @GetMapping("/myBalance")

  public List<AccountTransactionDto> getBalance(@RequestParam Long id) {
    return balanceService.getBalanceDetail(id);
  }

}
