package com.gordon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

  @GetMapping("/myCards")
  public String getCardDetails() {
    return "here are card details from DB";
  }
}
