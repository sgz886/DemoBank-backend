package com.gordon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BalanceController {

  @GetMapping("/myBalance")
  public String getBalanceDetails() {
    return "here are balance details from DB";
  }

}
