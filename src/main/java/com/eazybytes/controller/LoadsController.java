package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadsController {

  @GetMapping("/myLoans")
  public String getLoanDetails() {
    return "Here are loan details from DB";
  }
}
