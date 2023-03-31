package com.gordon.controller;

import com.gordon.dto.CardDto;
import com.gordon.service.CardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {

  private final CardService cardService;
  @GetMapping("/myCards")
  public List<CardDto> getCardDetails(@RequestParam Long id) {
    return cardService.getCardDetails(id);
  }
}
