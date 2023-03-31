package com.gordon.controller;

import com.gordon.dto.LoanDto;
import com.gordon.service.LoanService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoanController {

  private final LoanService loanService;
  @GetMapping("/myLoans")
  public List<LoanDto> getLoanDetails(@RequestParam Long id) {
    return loanService.getLoans(id);
  }
}
